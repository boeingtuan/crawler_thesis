/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bk.thesis.data.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-07-20")
public class TRawReviewResult implements org.apache.thrift.TBase<TRawReviewResult, TRawReviewResult._Fields>, java.io.Serializable, Cloneable, Comparable<TRawReviewResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TRawReviewResult");

  private static final org.apache.thrift.protocol.TField CER_REVIEWS_FIELD_DESC = new org.apache.thrift.protocol.TField("cerReviews", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField NOTCER_REVIEWS_FIELD_DESC = new org.apache.thrift.protocol.TField("notcerReviews", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField LIST_RAW_REVIEW_FIELD_DESC = new org.apache.thrift.protocol.TField("listRawReview", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField CAN_CONT_FIELD_DESC = new org.apache.thrift.protocol.TField("canCont", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TRawReviewResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TRawReviewResultTupleSchemeFactory();

  public TReviewMeta cerReviews; // required
  public TReviewMeta notcerReviews; // required
  public java.util.List<TRawReview> listRawReview; // required
  public boolean canCont; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CER_REVIEWS((short)1, "cerReviews"),
    NOTCER_REVIEWS((short)2, "notcerReviews"),
    LIST_RAW_REVIEW((short)3, "listRawReview"),
    CAN_CONT((short)4, "canCont");

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
        case 1: // CER_REVIEWS
          return CER_REVIEWS;
        case 2: // NOTCER_REVIEWS
          return NOTCER_REVIEWS;
        case 3: // LIST_RAW_REVIEW
          return LIST_RAW_REVIEW;
        case 4: // CAN_CONT
          return CAN_CONT;
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
  private static final int __CANCONT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CER_REVIEWS, new org.apache.thrift.meta_data.FieldMetaData("cerReviews", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TReviewMeta.class)));
    tmpMap.put(_Fields.NOTCER_REVIEWS, new org.apache.thrift.meta_data.FieldMetaData("notcerReviews", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TReviewMeta.class)));
    tmpMap.put(_Fields.LIST_RAW_REVIEW, new org.apache.thrift.meta_data.FieldMetaData("listRawReview", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TRawReview.class))));
    tmpMap.put(_Fields.CAN_CONT, new org.apache.thrift.meta_data.FieldMetaData("canCont", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TRawReviewResult.class, metaDataMap);
  }

  public TRawReviewResult() {
  }

  public TRawReviewResult(
    TReviewMeta cerReviews,
    TReviewMeta notcerReviews,
    java.util.List<TRawReview> listRawReview,
    boolean canCont)
  {
    this();
    this.cerReviews = cerReviews;
    this.notcerReviews = notcerReviews;
    this.listRawReview = listRawReview;
    this.canCont = canCont;
    setCanContIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TRawReviewResult(TRawReviewResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetCerReviews()) {
      this.cerReviews = new TReviewMeta(other.cerReviews);
    }
    if (other.isSetNotcerReviews()) {
      this.notcerReviews = new TReviewMeta(other.notcerReviews);
    }
    if (other.isSetListRawReview()) {
      java.util.List<TRawReview> __this__listRawReview = new java.util.ArrayList<TRawReview>(other.listRawReview.size());
      for (TRawReview other_element : other.listRawReview) {
        __this__listRawReview.add(new TRawReview(other_element));
      }
      this.listRawReview = __this__listRawReview;
    }
    this.canCont = other.canCont;
  }

  public TRawReviewResult deepCopy() {
    return new TRawReviewResult(this);
  }

  @Override
  public void clear() {
    this.cerReviews = null;
    this.notcerReviews = null;
    this.listRawReview = null;
    setCanContIsSet(false);
    this.canCont = false;
  }

  public TReviewMeta getCerReviews() {
    return this.cerReviews;
  }

  public TRawReviewResult setCerReviews(TReviewMeta cerReviews) {
    this.cerReviews = cerReviews;
    return this;
  }

  public void unsetCerReviews() {
    this.cerReviews = null;
  }

  /** Returns true if field cerReviews is set (has been assigned a value) and false otherwise */
  public boolean isSetCerReviews() {
    return this.cerReviews != null;
  }

  public void setCerReviewsIsSet(boolean value) {
    if (!value) {
      this.cerReviews = null;
    }
  }

  public TReviewMeta getNotcerReviews() {
    return this.notcerReviews;
  }

  public TRawReviewResult setNotcerReviews(TReviewMeta notcerReviews) {
    this.notcerReviews = notcerReviews;
    return this;
  }

  public void unsetNotcerReviews() {
    this.notcerReviews = null;
  }

  /** Returns true if field notcerReviews is set (has been assigned a value) and false otherwise */
  public boolean isSetNotcerReviews() {
    return this.notcerReviews != null;
  }

  public void setNotcerReviewsIsSet(boolean value) {
    if (!value) {
      this.notcerReviews = null;
    }
  }

  public int getListRawReviewSize() {
    return (this.listRawReview == null) ? 0 : this.listRawReview.size();
  }

  public java.util.Iterator<TRawReview> getListRawReviewIterator() {
    return (this.listRawReview == null) ? null : this.listRawReview.iterator();
  }

  public void addToListRawReview(TRawReview elem) {
    if (this.listRawReview == null) {
      this.listRawReview = new java.util.ArrayList<TRawReview>();
    }
    this.listRawReview.add(elem);
  }

  public java.util.List<TRawReview> getListRawReview() {
    return this.listRawReview;
  }

  public TRawReviewResult setListRawReview(java.util.List<TRawReview> listRawReview) {
    this.listRawReview = listRawReview;
    return this;
  }

  public void unsetListRawReview() {
    this.listRawReview = null;
  }

  /** Returns true if field listRawReview is set (has been assigned a value) and false otherwise */
  public boolean isSetListRawReview() {
    return this.listRawReview != null;
  }

  public void setListRawReviewIsSet(boolean value) {
    if (!value) {
      this.listRawReview = null;
    }
  }

  public boolean isCanCont() {
    return this.canCont;
  }

  public TRawReviewResult setCanCont(boolean canCont) {
    this.canCont = canCont;
    setCanContIsSet(true);
    return this;
  }

  public void unsetCanCont() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CANCONT_ISSET_ID);
  }

  /** Returns true if field canCont is set (has been assigned a value) and false otherwise */
  public boolean isSetCanCont() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CANCONT_ISSET_ID);
  }

  public void setCanContIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CANCONT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case CER_REVIEWS:
      if (value == null) {
        unsetCerReviews();
      } else {
        setCerReviews((TReviewMeta)value);
      }
      break;

    case NOTCER_REVIEWS:
      if (value == null) {
        unsetNotcerReviews();
      } else {
        setNotcerReviews((TReviewMeta)value);
      }
      break;

    case LIST_RAW_REVIEW:
      if (value == null) {
        unsetListRawReview();
      } else {
        setListRawReview((java.util.List<TRawReview>)value);
      }
      break;

    case CAN_CONT:
      if (value == null) {
        unsetCanCont();
      } else {
        setCanCont((java.lang.Boolean)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case CER_REVIEWS:
      return getCerReviews();

    case NOTCER_REVIEWS:
      return getNotcerReviews();

    case LIST_RAW_REVIEW:
      return getListRawReview();

    case CAN_CONT:
      return isCanCont();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case CER_REVIEWS:
      return isSetCerReviews();
    case NOTCER_REVIEWS:
      return isSetNotcerReviews();
    case LIST_RAW_REVIEW:
      return isSetListRawReview();
    case CAN_CONT:
      return isSetCanCont();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TRawReviewResult)
      return this.equals((TRawReviewResult)that);
    return false;
  }

  public boolean equals(TRawReviewResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_cerReviews = true && this.isSetCerReviews();
    boolean that_present_cerReviews = true && that.isSetCerReviews();
    if (this_present_cerReviews || that_present_cerReviews) {
      if (!(this_present_cerReviews && that_present_cerReviews))
        return false;
      if (!this.cerReviews.equals(that.cerReviews))
        return false;
    }

    boolean this_present_notcerReviews = true && this.isSetNotcerReviews();
    boolean that_present_notcerReviews = true && that.isSetNotcerReviews();
    if (this_present_notcerReviews || that_present_notcerReviews) {
      if (!(this_present_notcerReviews && that_present_notcerReviews))
        return false;
      if (!this.notcerReviews.equals(that.notcerReviews))
        return false;
    }

    boolean this_present_listRawReview = true && this.isSetListRawReview();
    boolean that_present_listRawReview = true && that.isSetListRawReview();
    if (this_present_listRawReview || that_present_listRawReview) {
      if (!(this_present_listRawReview && that_present_listRawReview))
        return false;
      if (!this.listRawReview.equals(that.listRawReview))
        return false;
    }

    boolean this_present_canCont = true;
    boolean that_present_canCont = true;
    if (this_present_canCont || that_present_canCont) {
      if (!(this_present_canCont && that_present_canCont))
        return false;
      if (this.canCont != that.canCont)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetCerReviews()) ? 131071 : 524287);
    if (isSetCerReviews())
      hashCode = hashCode * 8191 + cerReviews.hashCode();

    hashCode = hashCode * 8191 + ((isSetNotcerReviews()) ? 131071 : 524287);
    if (isSetNotcerReviews())
      hashCode = hashCode * 8191 + notcerReviews.hashCode();

    hashCode = hashCode * 8191 + ((isSetListRawReview()) ? 131071 : 524287);
    if (isSetListRawReview())
      hashCode = hashCode * 8191 + listRawReview.hashCode();

    hashCode = hashCode * 8191 + ((canCont) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(TRawReviewResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetCerReviews()).compareTo(other.isSetCerReviews());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCerReviews()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cerReviews, other.cerReviews);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetNotcerReviews()).compareTo(other.isSetNotcerReviews());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNotcerReviews()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.notcerReviews, other.notcerReviews);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetListRawReview()).compareTo(other.isSetListRawReview());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetListRawReview()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.listRawReview, other.listRawReview);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCanCont()).compareTo(other.isSetCanCont());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCanCont()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.canCont, other.canCont);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TRawReviewResult(");
    boolean first = true;

    sb.append("cerReviews:");
    if (this.cerReviews == null) {
      sb.append("null");
    } else {
      sb.append(this.cerReviews);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("notcerReviews:");
    if (this.notcerReviews == null) {
      sb.append("null");
    } else {
      sb.append(this.notcerReviews);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("listRawReview:");
    if (this.listRawReview == null) {
      sb.append("null");
    } else {
      sb.append(this.listRawReview);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("canCont:");
    sb.append(this.canCont);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (cerReviews != null) {
      cerReviews.validate();
    }
    if (notcerReviews != null) {
      notcerReviews.validate();
    }
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

  private static class TRawReviewResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TRawReviewResultStandardScheme getScheme() {
      return new TRawReviewResultStandardScheme();
    }
  }

  private static class TRawReviewResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TRawReviewResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TRawReviewResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CER_REVIEWS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.cerReviews = new TReviewMeta();
              struct.cerReviews.read(iprot);
              struct.setCerReviewsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NOTCER_REVIEWS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.notcerReviews = new TReviewMeta();
              struct.notcerReviews.read(iprot);
              struct.setNotcerReviewsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LIST_RAW_REVIEW
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.listRawReview = new java.util.ArrayList<TRawReview>(_list0.size);
                TRawReview _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new TRawReview();
                  _elem1.read(iprot);
                  struct.listRawReview.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setListRawReviewIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CAN_CONT
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.canCont = iprot.readBool();
              struct.setCanContIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TRawReviewResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.cerReviews != null) {
        oprot.writeFieldBegin(CER_REVIEWS_FIELD_DESC);
        struct.cerReviews.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.notcerReviews != null) {
        oprot.writeFieldBegin(NOTCER_REVIEWS_FIELD_DESC);
        struct.notcerReviews.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.listRawReview != null) {
        oprot.writeFieldBegin(LIST_RAW_REVIEW_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.listRawReview.size()));
          for (TRawReview _iter3 : struct.listRawReview)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CAN_CONT_FIELD_DESC);
      oprot.writeBool(struct.canCont);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TRawReviewResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TRawReviewResultTupleScheme getScheme() {
      return new TRawReviewResultTupleScheme();
    }
  }

  private static class TRawReviewResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TRawReviewResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TRawReviewResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetCerReviews()) {
        optionals.set(0);
      }
      if (struct.isSetNotcerReviews()) {
        optionals.set(1);
      }
      if (struct.isSetListRawReview()) {
        optionals.set(2);
      }
      if (struct.isSetCanCont()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetCerReviews()) {
        struct.cerReviews.write(oprot);
      }
      if (struct.isSetNotcerReviews()) {
        struct.notcerReviews.write(oprot);
      }
      if (struct.isSetListRawReview()) {
        {
          oprot.writeI32(struct.listRawReview.size());
          for (TRawReview _iter4 : struct.listRawReview)
          {
            _iter4.write(oprot);
          }
        }
      }
      if (struct.isSetCanCont()) {
        oprot.writeBool(struct.canCont);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TRawReviewResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.cerReviews = new TReviewMeta();
        struct.cerReviews.read(iprot);
        struct.setCerReviewsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.notcerReviews = new TReviewMeta();
        struct.notcerReviews.read(iprot);
        struct.setNotcerReviewsIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.listRawReview = new java.util.ArrayList<TRawReview>(_list5.size);
          TRawReview _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new TRawReview();
            _elem6.read(iprot);
            struct.listRawReview.add(_elem6);
          }
        }
        struct.setListRawReviewIsSet(true);
      }
      if (incoming.get(3)) {
        struct.canCont = iprot.readBool();
        struct.setCanContIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

