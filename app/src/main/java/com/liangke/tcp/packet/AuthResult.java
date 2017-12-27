// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.liangke.tcp.packet;

/**
 * <pre>
 **
 * 鉴权结果
 * </pre>
 *
 * Protobuf enum {@code com.liangke.tcp.packet.AuthResult}
 */
public enum AuthResult
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   *鉴权失败,原因其他
   * </pre>
   *
   * <code>AUTH_RESULT_UNKNOW = 0;</code>
   */
  AUTH_RESULT_UNKNOW(0),
  /**
   * <pre>
   *鉴权成功
   * </pre>
   *
   * <code>AUTH_RESULT_OK = 1;</code>
   */
  AUTH_RESULT_OK(1),
  /**
   * <pre>
   *鉴权失败,无效TOKEN
   * </pre>
   *
   * <code>AUTH_RESULT_FAIL = 2;</code>
   */
  AUTH_RESULT_FAIL(2),
  /**
   * <pre>
   *鉴权失败,TOKEN重复鉴权
   * </pre>
   *
   * <code>AUTH_RESULT_REPEATED = 3;</code>
   */
  AUTH_RESULT_REPEATED(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   *鉴权失败,原因其他
   * </pre>
   *
   * <code>AUTH_RESULT_UNKNOW = 0;</code>
   */
  public static final int AUTH_RESULT_UNKNOW_VALUE = 0;
  /**
   * <pre>
   *鉴权成功
   * </pre>
   *
   * <code>AUTH_RESULT_OK = 1;</code>
   */
  public static final int AUTH_RESULT_OK_VALUE = 1;
  /**
   * <pre>
   *鉴权失败,无效TOKEN
   * </pre>
   *
   * <code>AUTH_RESULT_FAIL = 2;</code>
   */
  public static final int AUTH_RESULT_FAIL_VALUE = 2;
  /**
   * <pre>
   *鉴权失败,TOKEN重复鉴权
   * </pre>
   *
   * <code>AUTH_RESULT_REPEATED = 3;</code>
   */
  public static final int AUTH_RESULT_REPEATED_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @Deprecated
  public static AuthResult valueOf(int value) {
    return forNumber(value);
  }

  public static AuthResult forNumber(int value) {
    switch (value) {
      case 0: return AUTH_RESULT_UNKNOW;
      case 1: return AUTH_RESULT_OK;
      case 2: return AUTH_RESULT_FAIL;
      case 3: return AUTH_RESULT_REPEATED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<AuthResult>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      AuthResult> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<AuthResult>() {
          public AuthResult findValueByNumber(int number) {
            return AuthResult.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.liangke.tcp.packet.Chat.getDescriptor().getEnumTypes().get(2);
  }

  private static final AuthResult[] VALUES = values();

  public static AuthResult valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private AuthResult(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.liangke.tcp.packet.AuthResult)
}

