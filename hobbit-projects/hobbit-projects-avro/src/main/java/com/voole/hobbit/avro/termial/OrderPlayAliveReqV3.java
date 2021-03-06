/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.voole.hobbit.avro.termial;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class OrderPlayAliveReqV3 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderPlayAliveReqV3\",\"namespace\":\"com.voole.hobbit.avro.termial\",\"fields\":[{\"name\":\"sessID\",\"type\":[\"string\",\"null\"]},{\"name\":\"adjPlayTime\",\"type\":[\"long\",\"null\"]},{\"name\":\"accID\",\"type\":[\"long\",\"null\"]},{\"name\":\"aliveTick\",\"type\":[\"long\",\"null\"]},{\"name\":\"seekNum\",\"type\":[\"long\",\"null\"]},{\"name\":\"readNum\",\"type\":[\"long\",\"null\"]},{\"name\":\"unsuccRead\",\"type\":[\"long\",\"null\"]},{\"name\":\"readPos\",\"type\":[\"long\",\"null\"]},{\"name\":\"sessAvgSpeed\",\"type\":[\"long\",\"null\"]},{\"name\":\"sessSpeed\",\"type\":[\"long\",\"null\"]},{\"name\":\"linkNum\",\"type\":[\"int\",\"null\"]},{\"name\":\"cacheSizeCur\",\"type\":[\"long\",\"null\"]},{\"name\":\"_srvs\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"OrderPlayAliveReqSrvV3\",\"fields\":[{\"name\":\"srvIP\",\"type\":[\"long\",\"null\"]},{\"name\":\"connTimes\",\"type\":[\"long\",\"null\"]},{\"name\":\"transNum\",\"type\":[\"long\",\"null\"]},{\"name\":\"avgRTT\",\"type\":[\"long\",\"null\"]},{\"name\":\"accBytes\",\"type\":[\"long\",\"null\"]},{\"name\":\"accTime\",\"type\":[\"long\",\"null\"]},{\"name\":\"avgSpeed\",\"type\":[\"long\",\"null\"]},{\"name\":\"speed\",\"type\":[\"long\",\"null\"]},{\"name\":\"RTT\",\"type\":[\"long\",\"null\"]},{\"name\":\"nodeID\",\"type\":[\"long\",\"null\"]}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence sessID;
  @Deprecated public java.lang.Long adjPlayTime;
  @Deprecated public java.lang.Long accID;
  @Deprecated public java.lang.Long aliveTick;
  @Deprecated public java.lang.Long seekNum;
  @Deprecated public java.lang.Long readNum;
  @Deprecated public java.lang.Long unsuccRead;
  @Deprecated public java.lang.Long readPos;
  @Deprecated public java.lang.Long sessAvgSpeed;
  @Deprecated public java.lang.Long sessSpeed;
  @Deprecated public java.lang.Integer linkNum;
  @Deprecated public java.lang.Long cacheSizeCur;
  @Deprecated public java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3> _srvs;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public OrderPlayAliveReqV3() {}

  /**
   * All-args constructor.
   */
  public OrderPlayAliveReqV3(java.lang.CharSequence sessID, java.lang.Long adjPlayTime, java.lang.Long accID, java.lang.Long aliveTick, java.lang.Long seekNum, java.lang.Long readNum, java.lang.Long unsuccRead, java.lang.Long readPos, java.lang.Long sessAvgSpeed, java.lang.Long sessSpeed, java.lang.Integer linkNum, java.lang.Long cacheSizeCur, java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3> _srvs) {
    this.sessID = sessID;
    this.adjPlayTime = adjPlayTime;
    this.accID = accID;
    this.aliveTick = aliveTick;
    this.seekNum = seekNum;
    this.readNum = readNum;
    this.unsuccRead = unsuccRead;
    this.readPos = readPos;
    this.sessAvgSpeed = sessAvgSpeed;
    this.sessSpeed = sessSpeed;
    this.linkNum = linkNum;
    this.cacheSizeCur = cacheSizeCur;
    this._srvs = _srvs;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return sessID;
    case 1: return adjPlayTime;
    case 2: return accID;
    case 3: return aliveTick;
    case 4: return seekNum;
    case 5: return readNum;
    case 6: return unsuccRead;
    case 7: return readPos;
    case 8: return sessAvgSpeed;
    case 9: return sessSpeed;
    case 10: return linkNum;
    case 11: return cacheSizeCur;
    case 12: return _srvs;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: sessID = (java.lang.CharSequence)value$; break;
    case 1: adjPlayTime = (java.lang.Long)value$; break;
    case 2: accID = (java.lang.Long)value$; break;
    case 3: aliveTick = (java.lang.Long)value$; break;
    case 4: seekNum = (java.lang.Long)value$; break;
    case 5: readNum = (java.lang.Long)value$; break;
    case 6: unsuccRead = (java.lang.Long)value$; break;
    case 7: readPos = (java.lang.Long)value$; break;
    case 8: sessAvgSpeed = (java.lang.Long)value$; break;
    case 9: sessSpeed = (java.lang.Long)value$; break;
    case 10: linkNum = (java.lang.Integer)value$; break;
    case 11: cacheSizeCur = (java.lang.Long)value$; break;
    case 12: _srvs = (java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'sessID' field.
   */
  public java.lang.CharSequence getSessID() {
    return sessID;
  }

  /**
   * Sets the value of the 'sessID' field.
   * @param value the value to set.
   */
  public void setSessID(java.lang.CharSequence value) {
    this.sessID = value;
  }

  /**
   * Gets the value of the 'adjPlayTime' field.
   */
  public java.lang.Long getAdjPlayTime() {
    return adjPlayTime;
  }

  /**
   * Sets the value of the 'adjPlayTime' field.
   * @param value the value to set.
   */
  public void setAdjPlayTime(java.lang.Long value) {
    this.adjPlayTime = value;
  }

  /**
   * Gets the value of the 'accID' field.
   */
  public java.lang.Long getAccID() {
    return accID;
  }

  /**
   * Sets the value of the 'accID' field.
   * @param value the value to set.
   */
  public void setAccID(java.lang.Long value) {
    this.accID = value;
  }

  /**
   * Gets the value of the 'aliveTick' field.
   */
  public java.lang.Long getAliveTick() {
    return aliveTick;
  }

  /**
   * Sets the value of the 'aliveTick' field.
   * @param value the value to set.
   */
  public void setAliveTick(java.lang.Long value) {
    this.aliveTick = value;
  }

  /**
   * Gets the value of the 'seekNum' field.
   */
  public java.lang.Long getSeekNum() {
    return seekNum;
  }

  /**
   * Sets the value of the 'seekNum' field.
   * @param value the value to set.
   */
  public void setSeekNum(java.lang.Long value) {
    this.seekNum = value;
  }

  /**
   * Gets the value of the 'readNum' field.
   */
  public java.lang.Long getReadNum() {
    return readNum;
  }

  /**
   * Sets the value of the 'readNum' field.
   * @param value the value to set.
   */
  public void setReadNum(java.lang.Long value) {
    this.readNum = value;
  }

  /**
   * Gets the value of the 'unsuccRead' field.
   */
  public java.lang.Long getUnsuccRead() {
    return unsuccRead;
  }

  /**
   * Sets the value of the 'unsuccRead' field.
   * @param value the value to set.
   */
  public void setUnsuccRead(java.lang.Long value) {
    this.unsuccRead = value;
  }

  /**
   * Gets the value of the 'readPos' field.
   */
  public java.lang.Long getReadPos() {
    return readPos;
  }

  /**
   * Sets the value of the 'readPos' field.
   * @param value the value to set.
   */
  public void setReadPos(java.lang.Long value) {
    this.readPos = value;
  }

  /**
   * Gets the value of the 'sessAvgSpeed' field.
   */
  public java.lang.Long getSessAvgSpeed() {
    return sessAvgSpeed;
  }

  /**
   * Sets the value of the 'sessAvgSpeed' field.
   * @param value the value to set.
   */
  public void setSessAvgSpeed(java.lang.Long value) {
    this.sessAvgSpeed = value;
  }

  /**
   * Gets the value of the 'sessSpeed' field.
   */
  public java.lang.Long getSessSpeed() {
    return sessSpeed;
  }

  /**
   * Sets the value of the 'sessSpeed' field.
   * @param value the value to set.
   */
  public void setSessSpeed(java.lang.Long value) {
    this.sessSpeed = value;
  }

  /**
   * Gets the value of the 'linkNum' field.
   */
  public java.lang.Integer getLinkNum() {
    return linkNum;
  }

  /**
   * Sets the value of the 'linkNum' field.
   * @param value the value to set.
   */
  public void setLinkNum(java.lang.Integer value) {
    this.linkNum = value;
  }

  /**
   * Gets the value of the 'cacheSizeCur' field.
   */
  public java.lang.Long getCacheSizeCur() {
    return cacheSizeCur;
  }

  /**
   * Sets the value of the 'cacheSizeCur' field.
   * @param value the value to set.
   */
  public void setCacheSizeCur(java.lang.Long value) {
    this.cacheSizeCur = value;
  }

  /**
   * Gets the value of the '_srvs' field.
   */
  public java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3> getSrvs$1() {
    return _srvs;
  }

  /**
   * Sets the value of the '_srvs' field.
   * @param value the value to set.
   */
  public void setSrvs$1(java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3> value) {
    this._srvs = value;
  }

  /** Creates a new OrderPlayAliveReqV3 RecordBuilder */
  public static com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder newBuilder() {
    return new com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder();
  }
  
  /** Creates a new OrderPlayAliveReqV3 RecordBuilder by copying an existing Builder */
  public static com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder newBuilder(com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder other) {
    return new com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder(other);
  }
  
  /** Creates a new OrderPlayAliveReqV3 RecordBuilder by copying an existing OrderPlayAliveReqV3 instance */
  public static com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder newBuilder(com.voole.hobbit.avro.termial.OrderPlayAliveReqV3 other) {
    return new com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder(other);
  }
  
  /**
   * RecordBuilder for OrderPlayAliveReqV3 instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderPlayAliveReqV3>
    implements org.apache.avro.data.RecordBuilder<OrderPlayAliveReqV3> {

    private java.lang.CharSequence sessID;
    private java.lang.Long adjPlayTime;
    private java.lang.Long accID;
    private java.lang.Long aliveTick;
    private java.lang.Long seekNum;
    private java.lang.Long readNum;
    private java.lang.Long unsuccRead;
    private java.lang.Long readPos;
    private java.lang.Long sessAvgSpeed;
    private java.lang.Long sessSpeed;
    private java.lang.Integer linkNum;
    private java.lang.Long cacheSizeCur;
    private java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3> _srvs;

    /** Creates a new Builder */
    private Builder() {
      super(com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.sessID)) {
        this.sessID = data().deepCopy(fields()[0].schema(), other.sessID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.adjPlayTime)) {
        this.adjPlayTime = data().deepCopy(fields()[1].schema(), other.adjPlayTime);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.accID)) {
        this.accID = data().deepCopy(fields()[2].schema(), other.accID);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.aliveTick)) {
        this.aliveTick = data().deepCopy(fields()[3].schema(), other.aliveTick);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.seekNum)) {
        this.seekNum = data().deepCopy(fields()[4].schema(), other.seekNum);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.readNum)) {
        this.readNum = data().deepCopy(fields()[5].schema(), other.readNum);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.unsuccRead)) {
        this.unsuccRead = data().deepCopy(fields()[6].schema(), other.unsuccRead);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.readPos)) {
        this.readPos = data().deepCopy(fields()[7].schema(), other.readPos);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.sessAvgSpeed)) {
        this.sessAvgSpeed = data().deepCopy(fields()[8].schema(), other.sessAvgSpeed);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.sessSpeed)) {
        this.sessSpeed = data().deepCopy(fields()[9].schema(), other.sessSpeed);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.linkNum)) {
        this.linkNum = data().deepCopy(fields()[10].schema(), other.linkNum);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.cacheSizeCur)) {
        this.cacheSizeCur = data().deepCopy(fields()[11].schema(), other.cacheSizeCur);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other._srvs)) {
        this._srvs = data().deepCopy(fields()[12].schema(), other._srvs);
        fieldSetFlags()[12] = true;
      }
    }
    
    /** Creates a Builder by copying an existing OrderPlayAliveReqV3 instance */
    private Builder(com.voole.hobbit.avro.termial.OrderPlayAliveReqV3 other) {
            super(com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.SCHEMA$);
      if (isValidValue(fields()[0], other.sessID)) {
        this.sessID = data().deepCopy(fields()[0].schema(), other.sessID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.adjPlayTime)) {
        this.adjPlayTime = data().deepCopy(fields()[1].schema(), other.adjPlayTime);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.accID)) {
        this.accID = data().deepCopy(fields()[2].schema(), other.accID);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.aliveTick)) {
        this.aliveTick = data().deepCopy(fields()[3].schema(), other.aliveTick);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.seekNum)) {
        this.seekNum = data().deepCopy(fields()[4].schema(), other.seekNum);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.readNum)) {
        this.readNum = data().deepCopy(fields()[5].schema(), other.readNum);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.unsuccRead)) {
        this.unsuccRead = data().deepCopy(fields()[6].schema(), other.unsuccRead);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.readPos)) {
        this.readPos = data().deepCopy(fields()[7].schema(), other.readPos);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.sessAvgSpeed)) {
        this.sessAvgSpeed = data().deepCopy(fields()[8].schema(), other.sessAvgSpeed);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.sessSpeed)) {
        this.sessSpeed = data().deepCopy(fields()[9].schema(), other.sessSpeed);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.linkNum)) {
        this.linkNum = data().deepCopy(fields()[10].schema(), other.linkNum);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.cacheSizeCur)) {
        this.cacheSizeCur = data().deepCopy(fields()[11].schema(), other.cacheSizeCur);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other._srvs)) {
        this._srvs = data().deepCopy(fields()[12].schema(), other._srvs);
        fieldSetFlags()[12] = true;
      }
    }

    /** Gets the value of the 'sessID' field */
    public java.lang.CharSequence getSessID() {
      return sessID;
    }
    
    /** Sets the value of the 'sessID' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setSessID(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.sessID = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'sessID' field has been set */
    public boolean hasSessID() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'sessID' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearSessID() {
      sessID = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'adjPlayTime' field */
    public java.lang.Long getAdjPlayTime() {
      return adjPlayTime;
    }
    
    /** Sets the value of the 'adjPlayTime' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setAdjPlayTime(java.lang.Long value) {
      validate(fields()[1], value);
      this.adjPlayTime = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'adjPlayTime' field has been set */
    public boolean hasAdjPlayTime() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'adjPlayTime' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearAdjPlayTime() {
      adjPlayTime = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'accID' field */
    public java.lang.Long getAccID() {
      return accID;
    }
    
    /** Sets the value of the 'accID' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setAccID(java.lang.Long value) {
      validate(fields()[2], value);
      this.accID = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'accID' field has been set */
    public boolean hasAccID() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'accID' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearAccID() {
      accID = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'aliveTick' field */
    public java.lang.Long getAliveTick() {
      return aliveTick;
    }
    
    /** Sets the value of the 'aliveTick' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setAliveTick(java.lang.Long value) {
      validate(fields()[3], value);
      this.aliveTick = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'aliveTick' field has been set */
    public boolean hasAliveTick() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'aliveTick' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearAliveTick() {
      aliveTick = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'seekNum' field */
    public java.lang.Long getSeekNum() {
      return seekNum;
    }
    
    /** Sets the value of the 'seekNum' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setSeekNum(java.lang.Long value) {
      validate(fields()[4], value);
      this.seekNum = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'seekNum' field has been set */
    public boolean hasSeekNum() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'seekNum' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearSeekNum() {
      seekNum = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'readNum' field */
    public java.lang.Long getReadNum() {
      return readNum;
    }
    
    /** Sets the value of the 'readNum' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setReadNum(java.lang.Long value) {
      validate(fields()[5], value);
      this.readNum = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'readNum' field has been set */
    public boolean hasReadNum() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'readNum' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearReadNum() {
      readNum = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'unsuccRead' field */
    public java.lang.Long getUnsuccRead() {
      return unsuccRead;
    }
    
    /** Sets the value of the 'unsuccRead' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setUnsuccRead(java.lang.Long value) {
      validate(fields()[6], value);
      this.unsuccRead = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'unsuccRead' field has been set */
    public boolean hasUnsuccRead() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'unsuccRead' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearUnsuccRead() {
      unsuccRead = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'readPos' field */
    public java.lang.Long getReadPos() {
      return readPos;
    }
    
    /** Sets the value of the 'readPos' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setReadPos(java.lang.Long value) {
      validate(fields()[7], value);
      this.readPos = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'readPos' field has been set */
    public boolean hasReadPos() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'readPos' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearReadPos() {
      readPos = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'sessAvgSpeed' field */
    public java.lang.Long getSessAvgSpeed() {
      return sessAvgSpeed;
    }
    
    /** Sets the value of the 'sessAvgSpeed' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setSessAvgSpeed(java.lang.Long value) {
      validate(fields()[8], value);
      this.sessAvgSpeed = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'sessAvgSpeed' field has been set */
    public boolean hasSessAvgSpeed() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'sessAvgSpeed' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearSessAvgSpeed() {
      sessAvgSpeed = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'sessSpeed' field */
    public java.lang.Long getSessSpeed() {
      return sessSpeed;
    }
    
    /** Sets the value of the 'sessSpeed' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setSessSpeed(java.lang.Long value) {
      validate(fields()[9], value);
      this.sessSpeed = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'sessSpeed' field has been set */
    public boolean hasSessSpeed() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'sessSpeed' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearSessSpeed() {
      sessSpeed = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'linkNum' field */
    public java.lang.Integer getLinkNum() {
      return linkNum;
    }
    
    /** Sets the value of the 'linkNum' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setLinkNum(java.lang.Integer value) {
      validate(fields()[10], value);
      this.linkNum = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'linkNum' field has been set */
    public boolean hasLinkNum() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'linkNum' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearLinkNum() {
      linkNum = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'cacheSizeCur' field */
    public java.lang.Long getCacheSizeCur() {
      return cacheSizeCur;
    }
    
    /** Sets the value of the 'cacheSizeCur' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setCacheSizeCur(java.lang.Long value) {
      validate(fields()[11], value);
      this.cacheSizeCur = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'cacheSizeCur' field has been set */
    public boolean hasCacheSizeCur() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'cacheSizeCur' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearCacheSizeCur() {
      cacheSizeCur = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the '_srvs' field */
    public java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3> getSrvs$1() {
      return _srvs;
    }
    
    /** Sets the value of the '_srvs' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder setSrvs$1(java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3> value) {
      validate(fields()[12], value);
      this._srvs = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the '_srvs' field has been set */
    public boolean hasSrvs$1() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the '_srvs' field */
    public com.voole.hobbit.avro.termial.OrderPlayAliveReqV3.Builder clearSrvs$1() {
      _srvs = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    @Override
    public OrderPlayAliveReqV3 build() {
      try {
        OrderPlayAliveReqV3 record = new OrderPlayAliveReqV3();
        record.sessID = fieldSetFlags()[0] ? this.sessID : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.adjPlayTime = fieldSetFlags()[1] ? this.adjPlayTime : (java.lang.Long) defaultValue(fields()[1]);
        record.accID = fieldSetFlags()[2] ? this.accID : (java.lang.Long) defaultValue(fields()[2]);
        record.aliveTick = fieldSetFlags()[3] ? this.aliveTick : (java.lang.Long) defaultValue(fields()[3]);
        record.seekNum = fieldSetFlags()[4] ? this.seekNum : (java.lang.Long) defaultValue(fields()[4]);
        record.readNum = fieldSetFlags()[5] ? this.readNum : (java.lang.Long) defaultValue(fields()[5]);
        record.unsuccRead = fieldSetFlags()[6] ? this.unsuccRead : (java.lang.Long) defaultValue(fields()[6]);
        record.readPos = fieldSetFlags()[7] ? this.readPos : (java.lang.Long) defaultValue(fields()[7]);
        record.sessAvgSpeed = fieldSetFlags()[8] ? this.sessAvgSpeed : (java.lang.Long) defaultValue(fields()[8]);
        record.sessSpeed = fieldSetFlags()[9] ? this.sessSpeed : (java.lang.Long) defaultValue(fields()[9]);
        record.linkNum = fieldSetFlags()[10] ? this.linkNum : (java.lang.Integer) defaultValue(fields()[10]);
        record.cacheSizeCur = fieldSetFlags()[11] ? this.cacheSizeCur : (java.lang.Long) defaultValue(fields()[11]);
        record._srvs = fieldSetFlags()[12] ? this._srvs : (java.util.List<com.voole.hobbit.avro.termial.OrderPlayAliveReqSrvV3>) defaultValue(fields()[12]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
