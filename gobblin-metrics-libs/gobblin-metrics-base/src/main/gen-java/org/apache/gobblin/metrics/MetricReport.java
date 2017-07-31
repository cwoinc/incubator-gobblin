/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.apache.gobblin.metrics;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MetricReport extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8071998973089804574L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MetricReport\",\"namespace\":\"gobblin.metrics\",\"fields\":[{\"name\":\"tags\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},\"doc\":\"Tags associated with the metrics.\"},{\"name\":\"timestamp\",\"type\":\"long\",\"doc\":\"Time at which metrics were reported.\"},{\"name\":\"metrics\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Metric\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Metric name.\"},{\"name\":\"value\",\"type\":\"double\",\"doc\":\"Metric value.\"}]}},\"doc\":\"Array of metrics in this report.\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Tags associated with the metrics. */
  @Deprecated public java.util.Map<java.lang.String,java.lang.String> tags;
  /** Time at which metrics were reported. */
  @Deprecated public long timestamp;
  /** Array of metrics in this report. */
  @Deprecated public java.util.List<gobblin.metrics.Metric> metrics;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MetricReport() {}

  /**
   * All-args constructor.
   * @param tags Tags associated with the metrics.
   * @param timestamp Time at which metrics were reported.
   * @param metrics Array of metrics in this report.
   */
  public MetricReport(java.util.Map<java.lang.String,java.lang.String> tags, java.lang.Long timestamp, java.util.List<gobblin.metrics.Metric> metrics) {
    this.tags = tags;
    this.timestamp = timestamp;
    this.metrics = metrics;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return tags;
    case 1: return timestamp;
    case 2: return metrics;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: tags = (java.util.Map<java.lang.String,java.lang.String>)value$; break;
    case 1: timestamp = (java.lang.Long)value$; break;
    case 2: metrics = (java.util.List<gobblin.metrics.Metric>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'tags' field.
   * @return Tags associated with the metrics.
   */
  public java.util.Map<java.lang.String,java.lang.String> getTags() {
    return tags;
  }

  /**
   * Sets the value of the 'tags' field.
   * Tags associated with the metrics.
   * @param value the value to set.
   */
  public void setTags(java.util.Map<java.lang.String,java.lang.String> value) {
    this.tags = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return Time at which metrics were reported.
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * Time at which metrics were reported.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'metrics' field.
   * @return Array of metrics in this report.
   */
  public java.util.List<gobblin.metrics.Metric> getMetrics() {
    return metrics;
  }

  /**
   * Sets the value of the 'metrics' field.
   * Array of metrics in this report.
   * @param value the value to set.
   */
  public void setMetrics(java.util.List<gobblin.metrics.Metric> value) {
    this.metrics = value;
  }

  /**
   * Creates a new MetricReport RecordBuilder.
   * @return A new MetricReport RecordBuilder
   */
  public static org.apache.gobblin.metrics.MetricReport.Builder newBuilder() {
    return new org.apache.gobblin.metrics.MetricReport.Builder();
  }

  /**
   * Creates a new MetricReport RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MetricReport RecordBuilder
   */
  public static org.apache.gobblin.metrics.MetricReport.Builder newBuilder(gobblin.metrics.MetricReport.Builder other) {
    return new org.apache.gobblin.metrics.MetricReport.Builder(other);
  }

  /**
   * Creates a new MetricReport RecordBuilder by copying an existing MetricReport instance.
   * @param other The existing instance to copy.
   * @return A new MetricReport RecordBuilder
   */
  public static org.apache.gobblin.metrics.MetricReport.Builder newBuilder(gobblin.metrics.MetricReport other) {
    return new org.apache.gobblin.metrics.MetricReport.Builder(other);
  }

  /**
   * RecordBuilder for MetricReport instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MetricReport>
    implements org.apache.avro.data.RecordBuilder<MetricReport> {

    /** Tags associated with the metrics. */
    private java.util.Map<java.lang.String,java.lang.String> tags;
    /** Time at which metrics were reported. */
    private long timestamp;
    /** Array of metrics in this report. */
    private java.util.List<gobblin.metrics.Metric> metrics;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(gobblin.metrics.MetricReport.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.tags)) {
        this.tags = data().deepCopy(fields()[0].schema(), other.tags);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.metrics)) {
        this.metrics = data().deepCopy(fields()[2].schema(), other.metrics);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing MetricReport instance
     * @param other The existing instance to copy.
     */
    private Builder(gobblin.metrics.MetricReport other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.tags)) {
        this.tags = data().deepCopy(fields()[0].schema(), other.tags);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.metrics)) {
        this.metrics = data().deepCopy(fields()[2].schema(), other.metrics);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'tags' field.
      * Tags associated with the metrics.
      * @return The value.
      */
    public java.util.Map<java.lang.String,java.lang.String> getTags() {
      return tags;
    }

    /**
      * Sets the value of the 'tags' field.
      * Tags associated with the metrics.
      * @param value The value of 'tags'.
      * @return This builder.
      */
    public org.apache.gobblin.metrics.MetricReport.Builder setTags(java.util.Map<java.lang.String,java.lang.String> value) {
      validate(fields()[0], value);
      this.tags = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'tags' field has been set.
      * Tags associated with the metrics.
      * @return True if the 'tags' field has been set, false otherwise.
      */
    public boolean hasTags() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'tags' field.
      * Tags associated with the metrics.
      * @return This builder.
      */
    public org.apache.gobblin.metrics.MetricReport.Builder clearTags() {
      tags = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * Time at which metrics were reported.
      * @return The value.
      */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * Time at which metrics were reported.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public org.apache.gobblin.metrics.MetricReport.Builder setTimestamp(long value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * Time at which metrics were reported.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * Time at which metrics were reported.
      * @return This builder.
      */
    public org.apache.gobblin.metrics.MetricReport.Builder clearTimestamp() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'metrics' field.
      * Array of metrics in this report.
      * @return The value.
      */
    public java.util.List<gobblin.metrics.Metric> getMetrics() {
      return metrics;
    }

    /**
      * Sets the value of the 'metrics' field.
      * Array of metrics in this report.
      * @param value The value of 'metrics'.
      * @return This builder.
      */
    public org.apache.gobblin.metrics.MetricReport.Builder setMetrics(java.util.List<gobblin.metrics.Metric> value) {
      validate(fields()[2], value);
      this.metrics = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'metrics' field has been set.
      * Array of metrics in this report.
      * @return True if the 'metrics' field has been set, false otherwise.
      */
    public boolean hasMetrics() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'metrics' field.
      * Array of metrics in this report.
      * @return This builder.
      */
    public org.apache.gobblin.metrics.MetricReport.Builder clearMetrics() {
      metrics = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public MetricReport build() {
      try {
        MetricReport record = new MetricReport();
        record.tags = fieldSetFlags()[0] ? this.tags : (java.util.Map<java.lang.String,java.lang.String>) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (java.lang.Long) defaultValue(fields()[1]);
        record.metrics = fieldSetFlags()[2] ? this.metrics : (java.util.List<gobblin.metrics.Metric>) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
