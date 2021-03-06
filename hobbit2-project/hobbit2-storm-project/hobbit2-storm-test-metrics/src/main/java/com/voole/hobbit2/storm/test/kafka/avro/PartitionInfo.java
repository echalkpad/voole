/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.voole.hobbit2.storm.test.kafka.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PartitionInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PartitionInfo\",\"namespace\":\"com.voole.hobbit2.storm.test.kafka.avro\",\"fields\":[{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"PartitionInfoType\",\"symbols\":[\"BGN\",\"END\"]}},{\"name\":\"topic\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType type;
  @Deprecated public java.lang.CharSequence topic;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public PartitionInfo() {}

  /**
   * All-args constructor.
   */
  public PartitionInfo(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType type, java.lang.CharSequence topic) {
    this.type = type;
    this.topic = topic;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return type;
    case 1: return topic;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: type = (com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType)value$; break;
    case 1: topic = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'type' field.
   */
  public com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'topic' field.
   */
  public java.lang.CharSequence getTopic() {
    return topic;
  }

  /**
   * Sets the value of the 'topic' field.
   * @param value the value to set.
   */
  public void setTopic(java.lang.CharSequence value) {
    this.topic = value;
  }

  /** Creates a new PartitionInfo RecordBuilder */
  public static com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder newBuilder() {
    return new com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder();
  }
  
  /** Creates a new PartitionInfo RecordBuilder by copying an existing Builder */
  public static com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder newBuilder(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder other) {
    return new com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder(other);
  }
  
  /** Creates a new PartitionInfo RecordBuilder by copying an existing PartitionInfo instance */
  public static com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder newBuilder(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo other) {
    return new com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder(other);
  }
  
  /**
   * RecordBuilder for PartitionInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PartitionInfo>
    implements org.apache.avro.data.RecordBuilder<PartitionInfo> {

    private com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType type;
    private java.lang.CharSequence topic;

    /** Creates a new Builder */
    private Builder() {
      super(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.topic)) {
        this.topic = data().deepCopy(fields()[1].schema(), other.topic);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing PartitionInfo instance */
    private Builder(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo other) {
            super(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.SCHEMA$);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.topic)) {
        this.topic = data().deepCopy(fields()[1].schema(), other.topic);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'type' field */
    public com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType getType() {
      return type;
    }
    
    /** Sets the value of the 'type' field */
    public com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder setType(com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType value) {
      validate(fields()[0], value);
      this.type = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'type' field has been set */
    public boolean hasType() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'type' field */
    public com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder clearType() {
      type = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'topic' field */
    public java.lang.CharSequence getTopic() {
      return topic;
    }
    
    /** Sets the value of the 'topic' field */
    public com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder setTopic(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.topic = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'topic' field has been set */
    public boolean hasTopic() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'topic' field */
    public com.voole.hobbit2.storm.test.kafka.avro.PartitionInfo.Builder clearTopic() {
      topic = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public PartitionInfo build() {
      try {
        PartitionInfo record = new PartitionInfo();
        record.type = fieldSetFlags()[0] ? this.type : (com.voole.hobbit2.storm.test.kafka.avro.PartitionInfoType) defaultValue(fields()[0]);
        record.topic = fieldSetFlags()[1] ? this.topic : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
