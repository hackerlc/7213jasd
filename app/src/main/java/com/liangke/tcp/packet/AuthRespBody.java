// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.liangke.tcp.packet;

/**
 * <pre>
 **
 * 鉴权响应
 * </pre>
 *
 * Protobuf type {@code com.liangke.tcp.packet.AuthRespBody}
 */
public  final class AuthRespBody extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.liangke.tcp.packet.AuthRespBody)
    AuthRespBodyOrBuilder {
  // Use AuthRespBody.newBuilder() to construct.
  private AuthRespBody(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AuthRespBody() {
    time_ = 0L;
    result_ = 0;
    securityKey_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private AuthRespBody(
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
          case 8: {

            time_ = input.readInt64();
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            result_ = rawValue;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            securityKey_ = s;
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
    return com.liangke.tcp.packet.Chat.internal_static_com_liangke_tcp_packet_AuthRespBody_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.liangke.tcp.packet.Chat.internal_static_com_liangke_tcp_packet_AuthRespBody_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            AuthRespBody.class, Builder.class);
  }

  public static final int TIME_FIELD_NUMBER = 1;
  private long time_;
  /**
   * <pre>
   *消息发送时间
   * </pre>
   *
   * <code>int64 time = 1;</code>
   */
  public long getTime() {
    return time_;
  }

  public static final int RESULT_FIELD_NUMBER = 2;
  private int result_;
  /**
   * <pre>
   *鉴权结果
   * </pre>
   *
   * <code>.com.liangke.tcp.packet.AuthResult result = 2;</code>
   */
  public int getResultValue() {
    return result_;
  }
  /**
   * <pre>
   *鉴权结果
   * </pre>
   *
   * <code>.com.liangke.tcp.packet.AuthResult result = 2;</code>
   */
  public com.liangke.tcp.packet.AuthResult getResult() {
    com.liangke.tcp.packet.AuthResult result = com.liangke.tcp.packet.AuthResult.valueOf(result_);
    return result == null ? com.liangke.tcp.packet.AuthResult.UNRECOGNIZED : result;
  }

  public static final int SECURITYKEY_FIELD_NUMBER = 3;
  private volatile Object securityKey_;
  /**
   * <pre>
   *鉴权KEY
   * </pre>
   *
   * <code>string securityKey = 3;</code>
   */
  public String getSecurityKey() {
    Object ref = securityKey_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      securityKey_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *鉴权KEY
   * </pre>
   *
   * <code>string securityKey = 3;</code>
   */
  public com.google.protobuf.ByteString
      getSecurityKeyBytes() {
    Object ref = securityKey_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      securityKey_ = b;
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
    if (time_ != 0L) {
      output.writeInt64(1, time_);
    }
    if (result_ != com.liangke.tcp.packet.AuthResult.AUTH_RESULT_UNKNOW.getNumber()) {
      output.writeEnum(2, result_);
    }
    if (!getSecurityKeyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, securityKey_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (time_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, time_);
    }
    if (result_ != com.liangke.tcp.packet.AuthResult.AUTH_RESULT_UNKNOW.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, result_);
    }
    if (!getSecurityKeyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, securityKey_);
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
    if (!(obj instanceof AuthRespBody)) {
      return super.equals(obj);
    }
    AuthRespBody other = (AuthRespBody) obj;

    boolean result = true;
    result = result && (getTime()
        == other.getTime());
    result = result && result_ == other.result_;
    result = result && getSecurityKey()
        .equals(other.getSecurityKey());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTime());
    hash = (37 * hash) + RESULT_FIELD_NUMBER;
    hash = (53 * hash) + result_;
    hash = (37 * hash) + SECURITYKEY_FIELD_NUMBER;
    hash = (53 * hash) + getSecurityKey().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static AuthRespBody parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AuthRespBody parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AuthRespBody parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AuthRespBody parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AuthRespBody parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AuthRespBody parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static AuthRespBody parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static AuthRespBody parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static AuthRespBody parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AuthRespBody parseFrom(
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
  public static Builder newBuilder(AuthRespBody prototype) {
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
   * 鉴权响应
   * </pre>
   *
   * Protobuf type {@code com.liangke.tcp.packet.AuthRespBody}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.liangke.tcp.packet.AuthRespBody)
      com.liangke.tcp.packet.AuthRespBodyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.liangke.tcp.packet.Chat.internal_static_com_liangke_tcp_packet_AuthRespBody_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.liangke.tcp.packet.Chat.internal_static_com_liangke_tcp_packet_AuthRespBody_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AuthRespBody.class, Builder.class);
    }

    // Construct using com.liangke.tcp.packet.AuthRespBody.newBuilder()
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
      time_ = 0L;

      result_ = 0;

      securityKey_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.liangke.tcp.packet.Chat.internal_static_com_liangke_tcp_packet_AuthRespBody_descriptor;
    }

    public AuthRespBody getDefaultInstanceForType() {
      return AuthRespBody.getDefaultInstance();
    }

    public AuthRespBody build() {
      AuthRespBody result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public AuthRespBody buildPartial() {
      AuthRespBody result = new AuthRespBody(this);
      result.time_ = time_;
      result.result_ = result_;
      result.securityKey_ = securityKey_;
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
      if (other instanceof AuthRespBody) {
        return mergeFrom((AuthRespBody)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(AuthRespBody other) {
      if (other == AuthRespBody.getDefaultInstance()) return this;
      if (other.getTime() != 0L) {
        setTime(other.getTime());
      }
      if (other.result_ != 0) {
        setResultValue(other.getResultValue());
      }
      if (!other.getSecurityKey().isEmpty()) {
        securityKey_ = other.securityKey_;
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
      AuthRespBody parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (AuthRespBody) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long time_ ;
    /**
     * <pre>
     *消息发送时间
     * </pre>
     *
     * <code>int64 time = 1;</code>
     */
    public long getTime() {
      return time_;
    }
    /**
     * <pre>
     *消息发送时间
     * </pre>
     *
     * <code>int64 time = 1;</code>
     */
    public Builder setTime(long value) {
      
      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *消息发送时间
     * </pre>
     *
     * <code>int64 time = 1;</code>
     */
    public Builder clearTime() {
      
      time_ = 0L;
      onChanged();
      return this;
    }

    private int result_ = 0;
    /**
     * <pre>
     *鉴权结果
     * </pre>
     *
     * <code>.com.liangke.tcp.packet.AuthResult result = 2;</code>
     */
    public int getResultValue() {
      return result_;
    }
    /**
     * <pre>
     *鉴权结果
     * </pre>
     *
     * <code>.com.liangke.tcp.packet.AuthResult result = 2;</code>
     */
    public Builder setResultValue(int value) {
      result_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *鉴权结果
     * </pre>
     *
     * <code>.com.liangke.tcp.packet.AuthResult result = 2;</code>
     */
    public com.liangke.tcp.packet.AuthResult getResult() {
      com.liangke.tcp.packet.AuthResult result = com.liangke.tcp.packet.AuthResult.valueOf(result_);
      return result == null ? com.liangke.tcp.packet.AuthResult.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     *鉴权结果
     * </pre>
     *
     * <code>.com.liangke.tcp.packet.AuthResult result = 2;</code>
     */
    public Builder setResult(com.liangke.tcp.packet.AuthResult value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      result_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *鉴权结果
     * </pre>
     *
     * <code>.com.liangke.tcp.packet.AuthResult result = 2;</code>
     */
    public Builder clearResult() {
      
      result_ = 0;
      onChanged();
      return this;
    }

    private Object securityKey_ = "";
    /**
     * <pre>
     *鉴权KEY
     * </pre>
     *
     * <code>string securityKey = 3;</code>
     */
    public String getSecurityKey() {
      Object ref = securityKey_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        securityKey_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <pre>
     *鉴权KEY
     * </pre>
     *
     * <code>string securityKey = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSecurityKeyBytes() {
      Object ref = securityKey_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        securityKey_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *鉴权KEY
     * </pre>
     *
     * <code>string securityKey = 3;</code>
     */
    public Builder setSecurityKey(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      securityKey_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *鉴权KEY
     * </pre>
     *
     * <code>string securityKey = 3;</code>
     */
    public Builder clearSecurityKey() {
      
      securityKey_ = getDefaultInstance().getSecurityKey();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *鉴权KEY
     * </pre>
     *
     * <code>string securityKey = 3;</code>
     */
    public Builder setSecurityKeyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      securityKey_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.liangke.tcp.packet.AuthRespBody)
  }

  // @@protoc_insertion_point(class_scope:com.liangke.tcp.packet.AuthRespBody)
  private static final AuthRespBody DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AuthRespBody();
  }

  public static AuthRespBody getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AuthRespBody>
      PARSER = new com.google.protobuf.AbstractParser<AuthRespBody>() {
    public AuthRespBody parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new AuthRespBody(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AuthRespBody> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<AuthRespBody> getParserForType() {
    return PARSER;
  }

  public AuthRespBody getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

