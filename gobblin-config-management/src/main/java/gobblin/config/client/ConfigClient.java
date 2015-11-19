package gobblin.config.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.typesafe.config.Config;

import gobblin.config.configstore.ConfigStore;
import gobblin.config.configstore.ConfigStoreFactory;
import gobblin.config.configstore.impl.ConfigStoreCreationException;
import gobblin.config.configstore.impl.ETLHdfsConfigStoreFactory;
import gobblin.config.utils.URIComparator;


/**
 * ConfigClient is the consumer facing class for retrieving configuration against all configuration stores.
 * @author mitu
 *
 */
public class ConfigClient {

  public static enum VERSION_STABILITY_POLICY {
    RAISE_ERROR,
    CACHE_CONFIG_IN_MEMORY
  }

  private final VERSION_STABILITY_POLICY policy;

  // key is the store ROOT, must use TreeMap
  private final TreeMap<URI, ConfigStoreAccessor> configStoreMap = new TreeMap<URI, ConfigStoreAccessor>(
      new URIComparator());

  private ConfigClient(VERSION_STABILITY_POLICY policy) {
    this.policy = policy;
  }

  /**
   * @param policy - the policy control the behavior when this configuration client try to connect to configuration store.
   * if policy is RAISE_ERROR and this client try to connect to any {@gobblin.config.configstore.ConfigStore} which is not
   * {@gobblin.config.configstore.ConfigStoreWithStableVersion}, the RuntimeException will be thrown
   * 
   * if policy is CACHE_CONFIG_IN_MEMORY and this client try to connect to any {@gobblin.config.configstore.ConfigStore} which is not
   * {@gobblin.config.configstore.ConfigStoreWithStableVersion}, the consumer need to cache the retrieved configuration in memory,
   * otherwise, the same query for the same URI against same configuration store may result different result.
   * @return - the Configuration Client object
   */
  public static ConfigClient createConfigClientWithStableVersion(VERSION_STABILITY_POLICY policy) {
    return new ConfigClient(policy);
  }

  /**
   * 
   * @return the {@ConfigClient} with policy set to VERSION_STABILITY_POLICY.RAISE_ERROR
   */
  public static ConfigClient createDefaultConfigClient() {
    // create with stable versions
    return createConfigClientWithStableVersion(VERSION_STABILITY_POLICY.RAISE_ERROR);
  }

  private ConfigStoreAccessor getConfigStoreAccessor(URI uri) throws Exception {
    if (this.configStoreMap.containsKey(uri)) {
      return this.configStoreMap.get(uri);
    }

    ConfigStoreFactory<ConfigStore> csFactory = this.getConfigStoreFactory(uri);
    ConfigStore cs = csFactory.createConfigStore(uri);
    
    // ConfigStoreFactory scheme name could be different than configStore's StoreURI's scheme name
    URI csRoot = cs.getStoreURI();
    URI key = new URI(csFactory.getScheme(), csRoot.getAuthority(), csRoot.getPath(), csRoot.getQuery(), csRoot.getFragment());
    ConfigStoreAccessor value = new ConfigStoreAccessor(cs, cs.getCurrentVersion());
    this.configStoreMap.put(key, value);
    return value;
  }

  // TBD, need to use serviceLoader
  private ConfigStoreFactory<ConfigStore> getConfigStoreFactory(URI uri) throws Exception {
    return new ETLHdfsConfigStoreFactory();
  }

  // public APIs
  /**
   * 
   * @param uri - must start with scheme name
   * @return - the directly and indirectly specified configuration in {@com.typesafe.config.Config} format for input uri 
   * 
   * <p>
   * detail logics:
   * 0. Used the ConfigStoreAccessor in the cached map if previous ConfigStore been queried
   * 1. Based the scheme name, using {@java.util.ServiceLoader} to find the first {@gobblin.config.configstore.ConfigStoreFactory}
   * 2. Use ConfigStoreFactory to create ConfigStore 
   *    using getDefaultConfigStore() if Authority is missing in uri
   *    using createConfigStore() if Authority is present
   *    One of the implementation for ConfigStore to determine the store root is
   *    by back tracing the input uri, the path which contains "_CONFIG_STORE" is the root
   * 4. Build ConfigStoreAccessor by checking the current version of the ConfigStore. Added the entry to theMap
   * 
   * 5. If the ConfigStore is NOT ConfigStoreWithResolution, need to do resolution in this client
   */
  public Config getConfig(URI uri) throws Exception{

    // from scheme, get all subclass of ConfigStoreFactory, match it's scheme name to get ConfigStoreFactory
    //    ConfigStore cs = ConfigStoreFactory.getDefaultConfigStore();
    //    theMap.put(cs.getServerURI, new ConfigStoreAccessor(cs.getCurrentVersion, cs));
    //    cs.getConfig(uri.getRelativePath());
    
    ConfigStoreAccessor csa = this.getConfigStoreAccessor(uri);
    csa.store.getOwnConfig(uri, csa.version);
    return null;
  }

  /**
   * @param uris - Collection of URI, each one much start with scheme name
   * @return - the java.util.Map. Key of the map is the URI, value of the Map is getConfig(URI key)
   */
  public Map<URI, Config> getConfigs(Collection<URI> uris) {
    return null;
  }

  /**
   * 
   * @param uri - URI which must start with scheme name
   * @param recursive - indicate to get the imported URI recursively or not
   * @return The java.util.Collection which contains all the URI imported by input uri
   * All the URIs must starts with scheme names
   */
  public Collection<URI> getImported(URI uri, boolean recursive) {
    return null;
  }

  /**
   * 
   * @param uri - URI which must start with scheme name
   * @param recursive - indicate to get the imported by URI recursively or not
   * @return The java.util.Collection which contains all the URI which import input uri
   */
  public Collection<URI> getImportedBy(URI uri, boolean recursive) {
    return null;
  }

  /**
   * 
   * @param uri - clean the cache for the configuration store which specified by input URI 
   * This will cause a new version of the URI to be retrieved next time it is called, which could be 
   * different from the last configuration received.
   */
  public void clearCache(URI uri) {

  }

  static class ConfigStoreAccessor {
    String version;
    ConfigStore store;
    ConfigStoreAccessor(ConfigStore cs, String v){
      this.store = cs;
      this.version = v;
    }
  }
}
