// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.liangke.tcp.packet;

public interface JoinRespBodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.liangke.tcp.packet.JoinRespBody)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *消息发送时间
   * </pre>
   *
   * <code>int64 time = 1;</code>
   */
  long getTime();

  /**
   * <code>.com.liangke.tcp.packet.JoinGroupResult result = 2;</code>
   */
  int getResultValue();
  /**
   * <code>.com.liangke.tcp.packet.JoinGroupResult result = 2;</code>
   */
  JoinGroupResult getResult();

  /**
   * <code>string group = 3;</code>
   */
  String getGroup();
  /**
   * <code>string group = 3;</code>
   */
  com.google.protobuf.ByteString
      getGroupBytes();
}
