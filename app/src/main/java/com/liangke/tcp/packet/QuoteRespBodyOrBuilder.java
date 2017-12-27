// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.liangke.tcp.packet;

public interface QuoteRespBodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.liangke.tcp.packet.QuoteRespBody)
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
   *行情订阅成功或者取消订阅成功的品种类型
   * </pre>
   *
   * <code>repeated .com.liangke.tcp.packet.CommodityType commodityType = 2;</code>
   */
  java.util.List<CommodityType>
      getCommodityTypeList();
  /**
   * <pre>
   *行情订阅成功或者取消订阅成功的品种类型
   * </pre>
   *
   * <code>repeated .com.liangke.tcp.packet.CommodityType commodityType = 2;</code>
   */
  CommodityType getCommodityType(int index);
  /**
   * <pre>
   *行情订阅成功或者取消订阅成功的品种类型
   * </pre>
   *
   * <code>repeated .com.liangke.tcp.packet.CommodityType commodityType = 2;</code>
   */
  int getCommodityTypeCount();
  /**
   * <pre>
   *行情订阅成功或者取消订阅成功的品种类型
   * </pre>
   *
   * <code>repeated .com.liangke.tcp.packet.CommodityType commodityType = 2;</code>
   */
  java.util.List<? extends CommodityTypeOrBuilder>
      getCommodityTypeOrBuilderList();
  /**
   * <pre>
   *行情订阅成功或者取消订阅成功的品种类型
   * </pre>
   *
   * <code>repeated .com.liangke.tcp.packet.CommodityType commodityType = 2;</code>
   */
  CommodityTypeOrBuilder getCommodityTypeOrBuilder(
          int index);
}
