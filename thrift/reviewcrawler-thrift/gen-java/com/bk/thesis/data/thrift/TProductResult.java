/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bk.thesis.data.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-07-20")
public class TProductResult implements org.apache.thrift.TBase<TProductResult, TProductResult._Fields>, java.io.Serializable, Cloneable, Comparable<TProductResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TProductResult");

  private static final org.apache.thrift.protocol.TField SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("size", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TIME_COMPUTED_FIELD_DESC = new org.apache.thrift.protocol.TField("timeComputed", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TProductResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TProductResultTupleSchemeFactory();

  public int size; // required
  public long timeComputed; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SIZE((short)1, "size"),
    TIME_COMPUTED((short)2, "timeComputed");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SIZE
          return SIZE;
        case 2: // TIME_COMPUTED
          return TIME_COMPUTED;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __SIZE_ISSET_ID = 0;
  private static final int __TIMECOMPUTED_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SIZE, new org.apache.thrift.meta_data.FieldMetaData("size", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TIME_COMPUTED, new org.apache.thrift.meta_data.FieldMetaData("timeComputed", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TProductResult.class, metaDataMap);
  }

  public TProductResult() {
  }

  public TProductResult(
    int size,
    long timeComputed)
  {
    this();
    this.size = size;
    setSizeIsSet(true);
    this.timeComputed = timeComputed;
    setTimeComputedIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TProductResult(TProductResult other) {
    __isset_bitfield = other.__isset_bitfield;
    this.size = other.size;
    this.timeComputed = other.timeComputed;
  }

  public TProductResult deepCopy() {
    return new TProductResult(this);
  }

  @Override
  public void clear() {
    setSizeIsSet(false);
    this.size = 0;
    setTimeComputedIsSet(false);
    this.timeComputed = 0;
  }

  public int getSize() {
    return this.size;
  }

  public TProductResult setSize(int size) {
    this.size = size;
    setSizeIsSet(true);
    return this;
  }

  public void unsetSize() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  /** Returns true if field size is set (has been assigned a value) and false otherwise */
  public boolean isSetSize() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SIZE_ISSET_ID);
  }

  public void setSizeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SIZE_ISSET_ID, value);
  }

  public long getTimeComputed() {
    return this.timeComputed;
  }

  public TProductResult setTimeComputed(long timeComputed) {
    this.timeComputed = timeComputed;
    setTimeComputedIsSet(true);
    return this;
  }

  public void unsetTimeComputed() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TIMECOMPUTED_ISSET_ID);
  }

  /** Returns true if field timeComputed is set (has been assigned a value) and false otherwise */
  public boolean isSetTimeComputed() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TIMECOMPUTED_ISSET_ID);
  }

  public void setTimeComputedIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TIMECOMPUTED_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case SIZE:
      if (value == null) {
        unsetSize();
      } else {
        setSize((java.lang.Integer)value);
      }
      break;

    case TIME_COMPUTED:
      if (value == null) {
        unsetTimeComputed();
      } else {
        setTimeComputed((java.lang.Long)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SIZE:
      return getSize();

    case TIME_COMPUTED:
      return getTimeComputed();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case SIZE:
      return isSetSize();
    case TIME_COMPUTED:
      return isSetTimeComputed();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TProductResult)
      return this.equals((TProductResult)that);
    return false;
  }

  public boolean equals(TProductResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_size = true;
    boolean that_present_size = true;
    if (this_present_size || that_present_size) {
      if (!(this_present_size && that_present_size))
        return false;
      if (this.size != that.size)
        return false;
    }

    boolean this_present_timeComputed = true;
    boolean that_present_timeComputed = true;
    if (this_present_timeComputed || that_present_timeComputed) {
      if (!(this_present_timeComputed && that_present_timeComputed))
        return false;
      if (this.timeComputed != that.timeComputed)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + size;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(timeComputed);

    return hashCode;
  }

  @Override
  public int compareTo(TProductResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetSize()).compareTo(other.isSetSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.size, other.size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTimeComputed()).compareTo(other.isSetTimeComputed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimeComputed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timeComputed, other.timeComputed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TProductResult(");
    boolean first = true;

    sb.append("size:");
    sb.append(this.size);
    first = false;
    if (!first) sb.append(", ");
    sb.append("timeComputed:");
    sb.append(this.timeComputed);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TProductResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TProductResultStandardScheme getScheme() {
      return new TProductResultStandardScheme();
    }
  }

  private static class TProductResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TProductResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TProductResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.size = iprot.readI32();
              struct.setSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TIME_COMPUTED
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeComputed = iprot.readI64();
              struct.setTimeComputedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TProductResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SIZE_FIELD_DESC);
      oprot.writeI32(struct.size);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TIME_COMPUTED_FIELD_DESC);
      oprot.writeI64(struct.timeComputed);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TProductResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TProductResultTupleScheme getScheme() {
      return new TProductResultTupleScheme();
    }
  }

  private static class TProductResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TProductResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TProductResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetSize()) {
        optionals.set(0);
      }
      if (struct.isSetTimeComputed()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetSize()) {
        oprot.writeI32(struct.size);
      }
      if (struct.isSetTimeComputed()) {
        oprot.writeI64(struct.timeComputed);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TProductResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.size = iprot.readI32();
        struct.setSizeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.timeComputed = iprot.readI64();
        struct.setTimeComputedIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

