/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.voole.dungbeetle.order.record.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class V3aLogRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"V3aLogRecord\",\"namespace\":\"com.voole.dungbeetle.order.record.avro\",\"fields\":[{\"name\":\"stamp\",\"type\":[\"long\",\"null\"]},{\"name\":\"userIp\",\"type\":[\"string\",\"null\"]},{\"name\":\"serverip\",\"type\":[\"string\",\"null\"]},{\"name\":\"hid\",\"type\":[\"string\",\"null\"]},{\"name\":\"oemid\",\"type\":[\"long\",\"null\"]},{\"name\":\"uid\",\"type\":[\"string\",\"null\"]},{\"name\":\"status\",\"type\":[\"int\",\"null\"]},{\"name\":\"hour\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.Long stamp;
  @Deprecated public java.lang.CharSequence userIp;
  @Deprecated public java.lang.CharSequence serverip;
  @Deprecated public java.lang.CharSequence hid;
  @Deprecated public java.lang.Long oemid;
  @Deprecated public java.lang.CharSequence uid;
  @Deprecated public java.lang.Integer status;
  @Deprecated public java.lang.CharSequence hour;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public V3aLogRecord() {}

  /**
   * All-args constructor.
   */
  public V3aLogRecord(java.lang.Long stamp, java.lang.CharSequence userIp, java.lang.CharSequence serverip, java.lang.CharSequence hid, java.lang.Long oemid, java.lang.CharSequence uid, java.lang.Integer status, java.lang.CharSequence hour) {
    this.stamp = stamp;
    this.userIp = userIp;
    this.serverip = serverip;
    this.hid = hid;
    this.oemid = oemid;
    this.uid = uid;
    this.status = status;
    this.hour = hour;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return stamp;
    case 1: return userIp;
    case 2: return serverip;
    case 3: return hid;
    case 4: return oemid;
    case 5: return uid;
    case 6: return status;
    case 7: return hour;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: stamp = (java.lang.Long)value$; break;
    case 1: userIp = (java.lang.CharSequence)value$; break;
    case 2: serverip = (java.lang.CharSequence)value$; break;
    case 3: hid = (java.lang.CharSequence)value$; break;
    case 4: oemid = (java.lang.Long)value$; break;
    case 5: uid = (java.lang.CharSequence)value$; break;
    case 6: status = (java.lang.Integer)value$; break;
    case 7: hour = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'stamp' field.
   */
  public java.lang.Long getStamp() {
    return stamp;
  }

  /**
   * Sets the value of the 'stamp' field.
   * @param value the value to set.
   */
  public void setStamp(java.lang.Long value) {
    this.stamp = value;
  }

  /**
   * Gets the value of the 'userIp' field.
   */
  public java.lang.CharSequence getUserIp() {
    return userIp;
  }

  /**
   * Sets the value of the 'userIp' field.
   * @param value the value to set.
   */
  public void setUserIp(java.lang.CharSequence value) {
    this.userIp = value;
  }

  /**
   * Gets the value of the 'serverip' field.
   */
  public java.lang.CharSequence getServerip() {
    return serverip;
  }

  /**
   * Sets the value of the 'serverip' field.
   * @param value the value to set.
   */
  public void setServerip(java.lang.CharSequence value) {
    this.serverip = value;
  }

  /**
   * Gets the value of the 'hid' field.
   */
  public java.lang.CharSequence getHid() {
    return hid;
  }

  /**
   * Sets the value of the 'hid' field.
   * @param value the value to set.
   */
  public void setHid(java.lang.CharSequence value) {
    this.hid = value;
  }

  /**
   * Gets the value of the 'oemid' field.
   */
  public java.lang.Long getOemid() {
    return oemid;
  }

  /**
   * Sets the value of the 'oemid' field.
   * @param value the value to set.
   */
  public void setOemid(java.lang.Long value) {
    this.oemid = value;
  }

  /**
   * Gets the value of the 'uid' field.
   */
  public java.lang.CharSequence getUid() {
    return uid;
  }

  /**
   * Sets the value of the 'uid' field.
   * @param value the value to set.
   */
  public void setUid(java.lang.CharSequence value) {
    this.uid = value;
  }

  /**
   * Gets the value of the 'status' field.
   */
  public java.lang.Integer getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(java.lang.Integer value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'hour' field.
   */
  public java.lang.CharSequence getHour() {
    return hour;
  }

  /**
   * Sets the value of the 'hour' field.
   * @param value the value to set.
   */
  public void setHour(java.lang.CharSequence value) {
    this.hour = value;
  }

  /** Creates a new V3aLogRecord RecordBuilder */
  public static com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder newBuilder() {
    return new com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder();
  }
  
  /** Creates a new V3aLogRecord RecordBuilder by copying an existing Builder */
  public static com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder newBuilder(com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder other) {
    return new com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder(other);
  }
  
  /** Creates a new V3aLogRecord RecordBuilder by copying an existing V3aLogRecord instance */
  public static com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder newBuilder(com.voole.dungbeetle.order.record.avro.V3aLogRecord other) {
    return new com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder(other);
  }
  
  /**
   * RecordBuilder for V3aLogRecord instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<V3aLogRecord>
    implements org.apache.avro.data.RecordBuilder<V3aLogRecord> {

    private java.lang.Long stamp;
    private java.lang.CharSequence userIp;
    private java.lang.CharSequence serverip;
    private java.lang.CharSequence hid;
    private java.lang.Long oemid;
    private java.lang.CharSequence uid;
    private java.lang.Integer status;
    private java.lang.CharSequence hour;

    /** Creates a new Builder */
    private Builder() {
      super(com.voole.dungbeetle.order.record.avro.V3aLogRecord.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.stamp)) {
        this.stamp = data().deepCopy(fields()[0].schema(), other.stamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.userIp)) {
        this.userIp = data().deepCopy(fields()[1].schema(), other.userIp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.serverip)) {
        this.serverip = data().deepCopy(fields()[2].schema(), other.serverip);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.hid)) {
        this.hid = data().deepCopy(fields()[3].schema(), other.hid);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.oemid)) {
        this.oemid = data().deepCopy(fields()[4].schema(), other.oemid);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.uid)) {
        this.uid = data().deepCopy(fields()[5].schema(), other.uid);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.status)) {
        this.status = data().deepCopy(fields()[6].schema(), other.status);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.hour)) {
        this.hour = data().deepCopy(fields()[7].schema(), other.hour);
        fieldSetFlags()[7] = true;
      }
    }
    
    /** Creates a Builder by copying an existing V3aLogRecord instance */
    private Builder(com.voole.dungbeetle.order.record.avro.V3aLogRecord other) {
            super(com.voole.dungbeetle.order.record.avro.V3aLogRecord.SCHEMA$);
      if (isValidValue(fields()[0], other.stamp)) {
        this.stamp = data().deepCopy(fields()[0].schema(), other.stamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.userIp)) {
        this.userIp = data().deepCopy(fields()[1].schema(), other.userIp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.serverip)) {
        this.serverip = data().deepCopy(fields()[2].schema(), other.serverip);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.hid)) {
        this.hid = data().deepCopy(fields()[3].schema(), other.hid);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.oemid)) {
        this.oemid = data().deepCopy(fields()[4].schema(), other.oemid);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.uid)) {
        this.uid = data().deepCopy(fields()[5].schema(), other.uid);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.status)) {
        this.status = data().deepCopy(fields()[6].schema(), other.status);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.hour)) {
        this.hour = data().deepCopy(fields()[7].schema(), other.hour);
        fieldSetFlags()[7] = true;
      }
    }

    /** Gets the value of the 'stamp' field */
    public java.lang.Long getStamp() {
      return stamp;
    }
    
    /** Sets the value of the 'stamp' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder setStamp(java.lang.Long value) {
      validate(fields()[0], value);
      this.stamp = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'stamp' field has been set */
    public boolean hasStamp() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'stamp' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder clearStamp() {
      stamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'userIp' field */
    public java.lang.CharSequence getUserIp() {
      return userIp;
    }
    
    /** Sets the value of the 'userIp' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder setUserIp(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.userIp = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'userIp' field has been set */
    public boolean hasUserIp() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'userIp' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder clearUserIp() {
      userIp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'serverip' field */
    public java.lang.CharSequence getServerip() {
      return serverip;
    }
    
    /** Sets the value of the 'serverip' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder setServerip(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.serverip = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'serverip' field has been set */
    public boolean hasServerip() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'serverip' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder clearServerip() {
      serverip = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'hid' field */
    public java.lang.CharSequence getHid() {
      return hid;
    }
    
    /** Sets the value of the 'hid' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder setHid(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.hid = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'hid' field has been set */
    public boolean hasHid() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'hid' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder clearHid() {
      hid = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'oemid' field */
    public java.lang.Long getOemid() {
      return oemid;
    }
    
    /** Sets the value of the 'oemid' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder setOemid(java.lang.Long value) {
      validate(fields()[4], value);
      this.oemid = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'oemid' field has been set */
    public boolean hasOemid() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'oemid' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder clearOemid() {
      oemid = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'uid' field */
    public java.lang.CharSequence getUid() {
      return uid;
    }
    
    /** Sets the value of the 'uid' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder setUid(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.uid = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'uid' field has been set */
    public boolean hasUid() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'uid' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder clearUid() {
      uid = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'status' field */
    public java.lang.Integer getStatus() {
      return status;
    }
    
    /** Sets the value of the 'status' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder setStatus(java.lang.Integer value) {
      validate(fields()[6], value);
      this.status = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'status' field has been set */
    public boolean hasStatus() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'status' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder clearStatus() {
      status = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'hour' field */
    public java.lang.CharSequence getHour() {
      return hour;
    }
    
    /** Sets the value of the 'hour' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder setHour(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.hour = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'hour' field has been set */
    public boolean hasHour() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'hour' field */
    public com.voole.dungbeetle.order.record.avro.V3aLogRecord.Builder clearHour() {
      hour = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    public V3aLogRecord build() {
      try {
        V3aLogRecord record = new V3aLogRecord();
        record.stamp = fieldSetFlags()[0] ? this.stamp : (java.lang.Long) defaultValue(fields()[0]);
        record.userIp = fieldSetFlags()[1] ? this.userIp : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.serverip = fieldSetFlags()[2] ? this.serverip : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.hid = fieldSetFlags()[3] ? this.hid : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.oemid = fieldSetFlags()[4] ? this.oemid : (java.lang.Long) defaultValue(fields()[4]);
        record.uid = fieldSetFlags()[5] ? this.uid : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.status = fieldSetFlags()[6] ? this.status : (java.lang.Integer) defaultValue(fields()[6]);
        record.hour = fieldSetFlags()[7] ? this.hour : (java.lang.CharSequence) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
