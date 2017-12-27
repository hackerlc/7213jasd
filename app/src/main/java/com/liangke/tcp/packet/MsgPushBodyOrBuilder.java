// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.liangke.tcp.packet;

public interface MsgPushBodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.liangke.tcp.packet.MsgPushBody)
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
   * <pre>
   *类型
   * </pre>
   *
   * <code>.com.liangke.tcp.packet.MsgType type = 2;</code>
   */
  int getTypeValue();
  /**
   * <pre>
   *类型
   * </pre>
   *
   * <code>.com.liangke.tcp.packet.MsgType type = 2;</code>
   */
  com.liangke.tcp.packet.MsgType getType();

  /**
   * <pre>
   *推送信息标题
   * </pre>
   *
   * <code>string title = 3;</code>
   */
  String getTitle();
  /**
   * <pre>
   *推送信息标题
   * </pre>
   *
   * <code>string title = 3;</code>
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <pre>
   *推送信息内容
   * </pre>
   *
   * <code>string text = 4;</code>
   */
  String getText();
  /**
   * <pre>
   *推送信息内容
   * </pre>
   *
   * <code>string text = 4;</code>
   */
  com.google.protobuf.ByteString
      getTextBytes();
}
