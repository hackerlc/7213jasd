// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.liangke.tcp.packet;

/**
 * <pre>
 **
 * 品种
 * </pre>
 *
 * Protobuf type {@code com.liangke.tcp.packet.CommodityType}
 */
public  final class CommodityType extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.liangke.tcp.packet.CommodityType)
    CommodityTypeOrBuilder {
  // Use CommodityType.newBuilder() to construct.
  private CommodityType(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CommodityType() {
    productId_ = "";
    commodityNo_ = "";
    contractNo_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private CommodityType(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            String s = input.readStringRequireUtf8();

            productId_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            commodityNo_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            contractNo_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Chat.internal_static_com_liangke_tcp_packet_CommodityType_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Chat.internal_static_com_liangke_tcp_packet_CommodityType_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            CommodityType.class, Builder.class);
  }

  public static final int PRODUCTID_FIELD_NUMBER = 1;
  private volatile Object productId_;
  /**
   * <pre>
   *交易所ID
   * </pre>
   *
   * <code>string productId = 1;</code>
   */
  public String getProductId() {
    Object ref = productId_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      productId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *交易所ID
   * </pre>
   *
   * <code>string productId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getProductIdBytes() {
    Object ref = productId_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      productId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int COMMODITYNO_FIELD_NUMBER = 2;
  private volatile Object commodityNo_;
  /**
   * <pre>
   * 订阅交易品种类型
   * </pre>
   *
   * <code>string commodityNo = 2;</code>
   */
  public String getCommodityNo() {
    Object ref = commodityNo_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      commodityNo_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 订阅交易品种类型
   * </pre>
   *
   * <code>string commodityNo = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCommodityNoBytes() {
    Object ref = commodityNo_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      commodityNo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CONTRACTNO_FIELD_NUMBER = 3;
  private volatile Object contractNo_;
  /**
   * <pre>
   * 订阅交易品种合约号,若无则为空字符串
   * </pre>
   *
   * <code>string contractNo = 3;</code>
   */
  public String getContractNo() {
    Object ref = contractNo_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      contractNo_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 订阅交易品种合约号,若无则为空字符串
   * </pre>
   *
   * <code>string contractNo = 3;</code>
   */
  public com.google.protobuf.ByteString
      getContractNoBytes() {
    Object ref = contractNo_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      contractNo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getProductIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, productId_);
    }
    if (!getCommodityNoBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, commodityNo_);
    }
    if (!getContractNoBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, contractNo_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getProductIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, productId_);
    }
    if (!getCommodityNoBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, commodityNo_);
    }
    if (!getContractNoBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, contractNo_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof CommodityType)) {
      return super.equals(obj);
    }
    CommodityType other = (CommodityType) obj;

    boolean result = true;
    result = result && getProductId()
        .equals(other.getProductId());
    result = result && getCommodityNo()
        .equals(other.getCommodityNo());
    result = result && getContractNo()
        .equals(other.getContractNo());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PRODUCTID_FIELD_NUMBER;
    hash = (53 * hash) + getProductId().hashCode();
    hash = (37 * hash) + COMMODITYNO_FIELD_NUMBER;
    hash = (53 * hash) + getCommodityNo().hashCode();
    hash = (37 * hash) + CONTRACTNO_FIELD_NUMBER;
    hash = (53 * hash) + getContractNo().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static CommodityType parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CommodityType parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CommodityType parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CommodityType parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CommodityType parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CommodityType parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static CommodityType parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static CommodityType parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static CommodityType parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CommodityType parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(CommodityType prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   **
   * 品种
   * </pre>
   *
   * Protobuf type {@code com.liangke.tcp.packet.CommodityType}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.liangke.tcp.packet.CommodityType)
      com.liangke.tcp.packet.CommodityTypeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Chat.internal_static_com_liangke_tcp_packet_CommodityType_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Chat.internal_static_com_liangke_tcp_packet_CommodityType_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CommodityType.class, Builder.class);
    }

    // Construct using com.liangke.tcp.packet.CommodityType.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      productId_ = "";

      commodityNo_ = "";

      contractNo_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Chat.internal_static_com_liangke_tcp_packet_CommodityType_descriptor;
    }

    public CommodityType getDefaultInstanceForType() {
      return CommodityType.getDefaultInstance();
    }

    public CommodityType build() {
      CommodityType result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public CommodityType buildPartial() {
      CommodityType result = new CommodityType(this);
      result.productId_ = productId_;
      result.commodityNo_ = commodityNo_;
      result.contractNo_ = contractNo_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof CommodityType) {
        return mergeFrom((CommodityType)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(CommodityType other) {
      if (other == CommodityType.getDefaultInstance()) return this;
      if (!other.getProductId().isEmpty()) {
        productId_ = other.productId_;
        onChanged();
      }
      if (!other.getCommodityNo().isEmpty()) {
        commodityNo_ = other.commodityNo_;
        onChanged();
      }
      if (!other.getContractNo().isEmpty()) {
        contractNo_ = other.contractNo_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      CommodityType parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (CommodityType) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object productId_ = "";
    /**
     * <pre>
     *交易所ID
     * </pre>
     *
     * <code>string productId = 1;</code>
     */
    public String getProductId() {
      Object ref = productId_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        productId_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <pre>
     *交易所ID
     * </pre>
     *
     * <code>string productId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getProductIdBytes() {
      Object ref = productId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        productId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *交易所ID
     * </pre>
     *
     * <code>string productId = 1;</code>
     */
    public Builder setProductId(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      productId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *交易所ID
     * </pre>
     *
     * <code>string productId = 1;</code>
     */
    public Builder clearProductId() {
      
      productId_ = getDefaultInstance().getProductId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *交易所ID
     * </pre>
     *
     * <code>string productId = 1;</code>
     */
    public Builder setProductIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      productId_ = value;
      onChanged();
      return this;
    }

    private Object commodityNo_ = "";
    /**
     * <pre>
     * 订阅交易品种类型
     * </pre>
     *
     * <code>string commodityNo = 2;</code>
     */
    public String getCommodityNo() {
      Object ref = commodityNo_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        commodityNo_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <pre>
     * 订阅交易品种类型
     * </pre>
     *
     * <code>string commodityNo = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCommodityNoBytes() {
      Object ref = commodityNo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        commodityNo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 订阅交易品种类型
     * </pre>
     *
     * <code>string commodityNo = 2;</code>
     */
    public Builder setCommodityNo(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      commodityNo_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 订阅交易品种类型
     * </pre>
     *
     * <code>string commodityNo = 2;</code>
     */
    public Builder clearCommodityNo() {
      
      commodityNo_ = getDefaultInstance().getCommodityNo();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 订阅交易品种类型
     * </pre>
     *
     * <code>string commodityNo = 2;</code>
     */
    public Builder setCommodityNoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      commodityNo_ = value;
      onChanged();
      return this;
    }

    private Object contractNo_ = "";
    /**
     * <pre>
     * 订阅交易品种合约号,若无则为空字符串
     * </pre>
     *
     * <code>string contractNo = 3;</code>
     */
    public String getContractNo() {
      Object ref = contractNo_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        contractNo_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <pre>
     * 订阅交易品种合约号,若无则为空字符串
     * </pre>
     *
     * <code>string contractNo = 3;</code>
     */
    public com.google.protobuf.ByteString
        getContractNoBytes() {
      Object ref = contractNo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        contractNo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 订阅交易品种合约号,若无则为空字符串
     * </pre>
     *
     * <code>string contractNo = 3;</code>
     */
    public Builder setContractNo(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      contractNo_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 订阅交易品种合约号,若无则为空字符串
     * </pre>
     *
     * <code>string contractNo = 3;</code>
     */
    public Builder clearContractNo() {
      
      contractNo_ = getDefaultInstance().getContractNo();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 订阅交易品种合约号,若无则为空字符串
     * </pre>
     *
     * <code>string contractNo = 3;</code>
     */
    public Builder setContractNoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      contractNo_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.liangke.tcp.packet.CommodityType)
  }

  // @@protoc_insertion_point(class_scope:com.liangke.tcp.packet.CommodityType)
  private static final CommodityType DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new CommodityType();
  }

  public static CommodityType getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CommodityType>
      PARSER = new com.google.protobuf.AbstractParser<CommodityType>() {
    public CommodityType parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CommodityType(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CommodityType> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<CommodityType> getParserForType() {
    return PARSER;
  }

  public CommodityType getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
