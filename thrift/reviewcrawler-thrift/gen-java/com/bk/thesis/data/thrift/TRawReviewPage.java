/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bk.thesis.data.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-07-20")
public class TRawReviewPage implements org.apache.thrift.TBase<TRawReviewPage, TRawReviewPage._Fields>, java.io.Serializable, Cloneable, Comparable<TRawReviewPage> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TRawReviewPage");

  private static final org.apache.thrift.protocol.TField ERROR_FIELD_DESC = new org.apache.thrift.protocol.TField("error", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField EXIST_FIELD_DESC = new org.apache.thrift.protocol.TField("exist", org.apache.thrift.protocol.TType.BOOL, (short)2);
  private static final org.apache.thrift.protocol.TField PAGE_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("pageData", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TRawReviewPageStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TRawReviewPageTupleSchemeFactory();

  public boolean error; // required
  public boolean exist; // required
  public java.lang.String pageData; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ERROR((short)1, "error"),
    EXIST((short)2, "exist"),
    PAGE_DATA((short)3, "pageData");

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
        case 1: // ERROR
          return ERROR;
        case 2: // EXIST
          return EXIST;
        case 3: // PAGE_DATA
          return PAGE_DATA;
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
  private static final int __ERROR_ISSET_ID = 0;
  private static final int __EXIST_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PAGE_DATA};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERROR, new org.apache.thrift.meta_data.FieldMetaData("error", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.EXIST, new org.apache.thrift.meta_data.FieldMetaData("exist", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.PAGE_DATA, new org.apache.thrift.meta_data.FieldMetaData("pageData", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TRawReviewPage.class, metaDataMap);
  }

  public TRawReviewPage() {
  }

  public TRawReviewPage(
    boolean error,
    boolean exist)
  {
    this();
    this.error = error;
    setErrorIsSet(true);
    this.exist = exist;
    setExistIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TRawReviewPage(TRawReviewPage other) {
    __isset_bitfield = other.__isset_bitfield;
    this.error = other.error;
    this.exist = other.exist;
    if (other.isSetPageData()) {
      this.pageData = other.pageData;
    }
  }

  public TRawReviewPage deepCopy() {
    return new TRawReviewPage(this);
  }

  @Override
  public void clear() {
    setErrorIsSet(false);
    this.error = false;
    setExistIsSet(false);
    this.exist = false;
    this.pageData = null;
  }

  public boolean isError() {
    return this.error;
  }

  public TRawReviewPage setError(boolean error) {
    this.error = error;
    setErrorIsSet(true);
    return this;
  }

  public void unsetError() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ERROR_ISSET_ID);
  }

  /** Returns true if field error is set (has been assigned a value) and false otherwise */
  public boolean isSetError() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ERROR_ISSET_ID);
  }

  public void setErrorIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ERROR_ISSET_ID, value);
  }

  public boolean isExist() {
    return this.exist;
  }

  public TRawReviewPage setExist(boolean exist) {
    this.exist = exist;
    setExistIsSet(true);
    return this;
  }

  public void unsetExist() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __EXIST_ISSET_ID);
  }

  /** Returns true if field exist is set (has been assigned a value) and false otherwise */
  public boolean isSetExist() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __EXIST_ISSET_ID);
  }

  public void setExistIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __EXIST_ISSET_ID, value);
  }

  public java.lang.String getPageData() {
    return this.pageData;
  }

  public TRawReviewPage setPageData(java.lang.String pageData) {
    this.pageData = pageData;
    return this;
  }

  public void unsetPageData() {
    this.pageData = null;
  }

  /** Returns true if field pageData is set (has been assigned a value) and false otherwise */
  public boolean isSetPageData() {
    return this.pageData != null;
  }

  public void setPageDataIsSet(boolean value) {
    if (!value) {
      this.pageData = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ERROR:
      if (value == null) {
        unsetError();
      } else {
        setError((java.lang.Boolean)value);
      }
      break;

    case EXIST:
      if (value == null) {
        unsetExist();
      } else {
        setExist((java.lang.Boolean)value);
      }
      break;

    case PAGE_DATA:
      if (value == null) {
        unsetPageData();
      } else {
        setPageData((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ERROR:
      return isError();

    case EXIST:
      return isExist();

    case PAGE_DATA:
      return getPageData();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ERROR:
      return isSetError();
    case EXIST:
      return isSetExist();
    case PAGE_DATA:
      return isSetPageData();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TRawReviewPage)
      return this.equals((TRawReviewPage)that);
    return false;
  }

  public boolean equals(TRawReviewPage that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_error = true;
    boolean that_present_error = true;
    if (this_present_error || that_present_error) {
      if (!(this_present_error && that_present_error))
        return false;
      if (this.error != that.error)
        return false;
    }

    boolean this_present_exist = true;
    boolean that_present_exist = true;
    if (this_present_exist || that_present_exist) {
      if (!(this_present_exist && that_present_exist))
        return false;
      if (this.exist != that.exist)
        return false;
    }

    boolean this_present_pageData = true && this.isSetPageData();
    boolean that_present_pageData = true && that.isSetPageData();
    if (this_present_pageData || that_present_pageData) {
      if (!(this_present_pageData && that_present_pageData))
        return false;
      if (!this.pageData.equals(that.pageData))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((error) ? 131071 : 524287);

    hashCode = hashCode * 8191 + ((exist) ? 131071 : 524287);

    hashCode = hashCode * 8191 + ((isSetPageData()) ? 131071 : 524287);
    if (isSetPageData())
      hashCode = hashCode * 8191 + pageData.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TRawReviewPage other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetError()).compareTo(other.isSetError());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetError()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.error, other.error);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetExist()).compareTo(other.isSetExist());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExist()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.exist, other.exist);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPageData()).compareTo(other.isSetPageData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageData, other.pageData);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TRawReviewPage(");
    boolean first = true;

    sb.append("error:");
    sb.append(this.error);
    first = false;
    if (!first) sb.append(", ");
    sb.append("exist:");
    sb.append(this.exist);
    first = false;
    if (isSetPageData()) {
      if (!first) sb.append(", ");
      sb.append("pageData:");
      if (this.pageData == null) {
        sb.append("null");
      } else {
        sb.append(this.pageData);
      }
      first = false;
    }
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

  private static class TRawReviewPageStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TRawReviewPageStandardScheme getScheme() {
      return new TRawReviewPageStandardScheme();
    }
  }

  private static class TRawReviewPageStandardScheme extends org.apache.thrift.scheme.StandardScheme<TRawReviewPage> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TRawReviewPage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ERROR
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.error = iprot.readBool();
              struct.setErrorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EXIST
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.exist = iprot.readBool();
              struct.setExistIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PAGE_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.pageData = iprot.readString();
              struct.setPageDataIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TRawReviewPage struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ERROR_FIELD_DESC);
      oprot.writeBool(struct.error);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(EXIST_FIELD_DESC);
      oprot.writeBool(struct.exist);
      oprot.writeFieldEnd();
      if (struct.pageData != null) {
        if (struct.isSetPageData()) {
          oprot.writeFieldBegin(PAGE_DATA_FIELD_DESC);
          oprot.writeString(struct.pageData);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TRawReviewPageTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TRawReviewPageTupleScheme getScheme() {
      return new TRawReviewPageTupleScheme();
    }
  }

  private static class TRawReviewPageTupleScheme extends org.apache.thrift.scheme.TupleScheme<TRawReviewPage> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TRawReviewPage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetError()) {
        optionals.set(0);
      }
      if (struct.isSetExist()) {
        optionals.set(1);
      }
      if (struct.isSetPageData()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetError()) {
        oprot.writeBool(struct.error);
      }
      if (struct.isSetExist()) {
        oprot.writeBool(struct.exist);
      }
      if (struct.isSetPageData()) {
        oprot.writeString(struct.pageData);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TRawReviewPage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.error = iprot.readBool();
        struct.setErrorIsSet(true);
      }
      if (incoming.get(1)) {
        struct.exist = iprot.readBool();
        struct.setExistIsSet(true);
      }
      if (incoming.get(2)) {
        struct.pageData = iprot.readString();
        struct.setPageDataIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

