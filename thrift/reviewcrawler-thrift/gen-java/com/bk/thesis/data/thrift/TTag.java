/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bk.thesis.data.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-07-20")
public class TTag implements org.apache.thrift.TBase<TTag, TTag._Fields>, java.io.Serializable, Cloneable, Comparable<TTag> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TTag");

  private static final org.apache.thrift.protocol.TField TAG_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tagId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PARENTS_FIELD_DESC = new org.apache.thrift.protocol.TField("parents", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TTagStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TTagTupleSchemeFactory();

  public int tagId; // required
  /**
   * 
   * @see ETagType
   */
  public ETagType type; // required
  public java.lang.String name; // required
  public java.util.List<java.lang.Integer> parents; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TAG_ID((short)1, "tagId"),
    /**
     * 
     * @see ETagType
     */
    TYPE((short)2, "type"),
    NAME((short)3, "name"),
    PARENTS((short)4, "parents");

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
        case 1: // TAG_ID
          return TAG_ID;
        case 2: // TYPE
          return TYPE;
        case 3: // NAME
          return NAME;
        case 4: // PARENTS
          return PARENTS;
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
  private static final int __TAGID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TAG_ID, new org.apache.thrift.meta_data.FieldMetaData("tagId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ETagType.class)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARENTS, new org.apache.thrift.meta_data.FieldMetaData("parents", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TTag.class, metaDataMap);
  }

  public TTag() {
  }

  public TTag(
    int tagId,
    ETagType type,
    java.lang.String name,
    java.util.List<java.lang.Integer> parents)
  {
    this();
    this.tagId = tagId;
    setTagIdIsSet(true);
    this.type = type;
    this.name = name;
    this.parents = parents;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TTag(TTag other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tagId = other.tagId;
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetParents()) {
      java.util.List<java.lang.Integer> __this__parents = new java.util.ArrayList<java.lang.Integer>(other.parents);
      this.parents = __this__parents;
    }
  }

  public TTag deepCopy() {
    return new TTag(this);
  }

  @Override
  public void clear() {
    setTagIdIsSet(false);
    this.tagId = 0;
    this.type = null;
    this.name = null;
    this.parents = null;
  }

  public int getTagId() {
    return this.tagId;
  }

  public TTag setTagId(int tagId) {
    this.tagId = tagId;
    setTagIdIsSet(true);
    return this;
  }

  public void unsetTagId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TAGID_ISSET_ID);
  }

  /** Returns true if field tagId is set (has been assigned a value) and false otherwise */
  public boolean isSetTagId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TAGID_ISSET_ID);
  }

  public void setTagIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TAGID_ISSET_ID, value);
  }

  /**
   * 
   * @see ETagType
   */
  public ETagType getType() {
    return this.type;
  }

  /**
   * 
   * @see ETagType
   */
  public TTag setType(ETagType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public java.lang.String getName() {
    return this.name;
  }

  public TTag setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public int getParentsSize() {
    return (this.parents == null) ? 0 : this.parents.size();
  }

  public java.util.Iterator<java.lang.Integer> getParentsIterator() {
    return (this.parents == null) ? null : this.parents.iterator();
  }

  public void addToParents(int elem) {
    if (this.parents == null) {
      this.parents = new java.util.ArrayList<java.lang.Integer>();
    }
    this.parents.add(elem);
  }

  public java.util.List<java.lang.Integer> getParents() {
    return this.parents;
  }

  public TTag setParents(java.util.List<java.lang.Integer> parents) {
    this.parents = parents;
    return this;
  }

  public void unsetParents() {
    this.parents = null;
  }

  /** Returns true if field parents is set (has been assigned a value) and false otherwise */
  public boolean isSetParents() {
    return this.parents != null;
  }

  public void setParentsIsSet(boolean value) {
    if (!value) {
      this.parents = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case TAG_ID:
      if (value == null) {
        unsetTagId();
      } else {
        setTagId((java.lang.Integer)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((ETagType)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case PARENTS:
      if (value == null) {
        unsetParents();
      } else {
        setParents((java.util.List<java.lang.Integer>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TAG_ID:
      return getTagId();

    case TYPE:
      return getType();

    case NAME:
      return getName();

    case PARENTS:
      return getParents();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TAG_ID:
      return isSetTagId();
    case TYPE:
      return isSetType();
    case NAME:
      return isSetName();
    case PARENTS:
      return isSetParents();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TTag)
      return this.equals((TTag)that);
    return false;
  }

  public boolean equals(TTag that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_tagId = true;
    boolean that_present_tagId = true;
    if (this_present_tagId || that_present_tagId) {
      if (!(this_present_tagId && that_present_tagId))
        return false;
      if (this.tagId != that.tagId)
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_parents = true && this.isSetParents();
    boolean that_present_parents = true && that.isSetParents();
    if (this_present_parents || that_present_parents) {
      if (!(this_present_parents && that_present_parents))
        return false;
      if (!this.parents.equals(that.parents))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + tagId;

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.getValue();

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetParents()) ? 131071 : 524287);
    if (isSetParents())
      hashCode = hashCode * 8191 + parents.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TTag other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetTagId()).compareTo(other.isSetTagId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTagId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tagId, other.tagId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetParents()).compareTo(other.isSetParents());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParents()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parents, other.parents);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TTag(");
    boolean first = true;

    sb.append("tagId:");
    sb.append(this.tagId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("parents:");
    if (this.parents == null) {
      sb.append("null");
    } else {
      sb.append(this.parents);
    }
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

  private static class TTagStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TTagStandardScheme getScheme() {
      return new TTagStandardScheme();
    }
  }

  private static class TTagStandardScheme extends org.apache.thrift.scheme.StandardScheme<TTag> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TTag struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TAG_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tagId = iprot.readI32();
              struct.setTagIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = com.bk.thesis.data.thrift.ETagType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PARENTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.parents = new java.util.ArrayList<java.lang.Integer>(_list8.size);
                int _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = iprot.readI32();
                  struct.parents.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setParentsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TTag struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TAG_ID_FIELD_DESC);
      oprot.writeI32(struct.tagId);
      oprot.writeFieldEnd();
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.parents != null) {
        oprot.writeFieldBegin(PARENTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.parents.size()));
          for (int _iter11 : struct.parents)
          {
            oprot.writeI32(_iter11);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TTagTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TTagTupleScheme getScheme() {
      return new TTagTupleScheme();
    }
  }

  private static class TTagTupleScheme extends org.apache.thrift.scheme.TupleScheme<TTag> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TTag struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTagId()) {
        optionals.set(0);
      }
      if (struct.isSetType()) {
        optionals.set(1);
      }
      if (struct.isSetName()) {
        optionals.set(2);
      }
      if (struct.isSetParents()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetTagId()) {
        oprot.writeI32(struct.tagId);
      }
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetParents()) {
        {
          oprot.writeI32(struct.parents.size());
          for (int _iter12 : struct.parents)
          {
            oprot.writeI32(_iter12);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TTag struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.tagId = iprot.readI32();
        struct.setTagIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.type = com.bk.thesis.data.thrift.ETagType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.parents = new java.util.ArrayList<java.lang.Integer>(_list13.size);
          int _elem14;
          for (int _i15 = 0; _i15 < _list13.size; ++_i15)
          {
            _elem14 = iprot.readI32();
            struct.parents.add(_elem14);
          }
        }
        struct.setParentsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

