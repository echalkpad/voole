/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.voole.avro.usage.model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroModelVersion1 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroModelVersion1\",\"namespace\":\"com.voole.avro.usage.model\",\"fields\":[{\"name\":\"name\",\"type\":[\"string\",\"null\"]},{\"name\":\"num\",\"type\":[\"long\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.Long num;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public AvroModelVersion1() {}

  /**
   * All-args constructor.
   */
  public AvroModelVersion1(java.lang.CharSequence name, java.lang.Long num) {
    this.name = name;
    this.num = num;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return num;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: num = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'num' field.
   */
  public java.lang.Long getNum() {
    return num;
  }

  /**
   * Sets the value of the 'num' field.
   * @param value the value to set.
   */
  public void setNum(java.lang.Long value) {
    this.num = value;
  }

  /** Creates a new AvroModelVersion1 RecordBuilder */
  public static com.voole.avro.usage.model.AvroModelVersion1.Builder newBuilder() {
    return new com.voole.avro.usage.model.AvroModelVersion1.Builder();
  }
  
  /** Creates a new AvroModelVersion1 RecordBuilder by copying an existing Builder */
  public static com.voole.avro.usage.model.AvroModelVersion1.Builder newBuilder(com.voole.avro.usage.model.AvroModelVersion1.Builder other) {
    return new com.voole.avro.usage.model.AvroModelVersion1.Builder(other);
  }
  
  /** Creates a new AvroModelVersion1 RecordBuilder by copying an existing AvroModelVersion1 instance */
  public static com.voole.avro.usage.model.AvroModelVersion1.Builder newBuilder(com.voole.avro.usage.model.AvroModelVersion1 other) {
    return new com.voole.avro.usage.model.AvroModelVersion1.Builder(other);
  }
  
  /**
   * RecordBuilder for AvroModelVersion1 instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroModelVersion1>
    implements org.apache.avro.data.RecordBuilder<AvroModelVersion1> {

    private java.lang.CharSequence name;
    private java.lang.Long num;

    /** Creates a new Builder */
    private Builder() {
      super(com.voole.avro.usage.model.AvroModelVersion1.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.voole.avro.usage.model.AvroModelVersion1.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.num)) {
        this.num = data().deepCopy(fields()[1].schema(), other.num);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing AvroModelVersion1 instance */
    private Builder(com.voole.avro.usage.model.AvroModelVersion1 other) {
            super(com.voole.avro.usage.model.AvroModelVersion1.SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.num)) {
        this.num = data().deepCopy(fields()[1].schema(), other.num);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'name' field */
    public java.lang.CharSequence getName() {
      return name;
    }
    
    /** Sets the value of the 'name' field */
    public com.voole.avro.usage.model.AvroModelVersion1.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'name' field has been set */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'name' field */
    public com.voole.avro.usage.model.AvroModelVersion1.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'num' field */
    public java.lang.Long getNum() {
      return num;
    }
    
    /** Sets the value of the 'num' field */
    public com.voole.avro.usage.model.AvroModelVersion1.Builder setNum(java.lang.Long value) {
      validate(fields()[1], value);
      this.num = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'num' field has been set */
    public boolean hasNum() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'num' field */
    public com.voole.avro.usage.model.AvroModelVersion1.Builder clearNum() {
      num = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public AvroModelVersion1 build() {
      try {
        AvroModelVersion1 record = new AvroModelVersion1();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.num = fieldSetFlags()[1] ? this.num : (java.lang.Long) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
