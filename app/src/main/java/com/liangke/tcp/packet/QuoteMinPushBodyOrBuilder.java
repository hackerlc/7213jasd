// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.liangke.tcp.packet;

public interface QuoteMinPushBodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.liangke.tcp.packet.QuoteMinPushBody)
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
   *交易所ID
   * </pre>
   *
   * <code>string productId = 2;</code>
   */
  String getProductId();
  /**
   * <pre>
   *交易所ID
   * </pre>
   *
   * <code>string productId = 2;</code>
   */
  com.google.protobuf.ByteString
      getProductIdBytes();

  /**
   * <pre>
   * 订阅商品类型
   * </pre>
   *
   * <code>string commodityNo = 3;</code>
   */
  String getCommodityNo();
  /**
   * <pre>
   * 订阅商品类型
   * </pre>
   *
   * <code>string commodityNo = 3;</code>
   */
  com.google.protobuf.ByteString
      getCommodityNoBytes();

  /**
   * <pre>
   * 商品合约号
   * </pre>
   *
   * <code>string contractNo = 4;</code>
   */
  String getContractNo();
  /**
   * <pre>
   * 商品合约号
   * </pre>
   *
   * <code>string contractNo = 4;</code>
   */
  com.google.protobuf.ByteString
      getContractNoBytes();

  /**
   * <pre>
   *推送行情类型
   * </pre>
   *
   * <code>.com.liangke.tcp.packet.QuoteType quoteType = 5;</code>
   */
  int getQuoteTypeValue();
  /**
   * <pre>
   *推送行情类型
   * </pre>
   *
   * <code>.com.liangke.tcp.packet.QuoteType quoteType = 5;</code>
   */
  com.liangke.tcp.packet.QuoteType getQuoteType();

  /**
   * <pre>
   *存数据库标记
   * </pre>
   *
   * <code>string uuid = 6;</code>
   */
  String getUuid();
  /**
   * <pre>
   *存数据库标记
   * </pre>
   *
   * <code>string uuid = 6;</code>
   */
  com.google.protobuf.ByteString
      getUuidBytes();

  /**
   * <pre>
   *行情时间,时间戳
   * </pre>
   *
   * <code>int64 ctm = 7;</code>
   */
  long getCtm();

  /**
   * <pre>
   *开盘价格
   * </pre>
   *
   * <code>string open = 8;</code>
   */
  String getOpen();
  /**
   * <pre>
   *开盘价格
   * </pre>
   *
   * <code>string open = 8;</code>
   */
  com.google.protobuf.ByteString
      getOpenBytes();

  /**
   * <pre>
   *收盘价格
   * </pre>
   *
   * <code>string close = 9;</code>
   */
  String getClose();
  /**
   * <pre>
   *收盘价格
   * </pre>
   *
   * <code>string close = 9;</code>
   */
  com.google.protobuf.ByteString
      getCloseBytes();

  /**
   * <pre>
   *最高价
   * </pre>
   *
   * <code>string high = 10;</code>
   */
  String getHigh();
  /**
   * <pre>
   *最高价
   * </pre>
   *
   * <code>string high = 10;</code>
   */
  com.google.protobuf.ByteString
      getHighBytes();

  /**
   * <pre>
   *最低价
   * </pre>
   *
   * <code>string low = 11;</code>
   */
  String getLow();
  /**
   * <pre>
   *最低价
   * </pre>
   *
   * <code>string low = 11;</code>
   */
  com.google.protobuf.ByteString
      getLowBytes();

  /**
   * <pre>
   *阶段买量
   * </pre>
   *
   * <code>string volume = 12;</code>
   */
  String getVolume();
  /**
   * <pre>
   *阶段买量
   * </pre>
   *
   * <code>string volume = 12;</code>
   */
  com.google.protobuf.ByteString
      getVolumeBytes();

  /**
   * <pre>
   *总买量
   * </pre>
   *
   * <code>string amount = 13;</code>
   */
  String getAmount();
  /**
   * <pre>
   *总买量
   * </pre>
   *
   * <code>string amount = 13;</code>
   */
  com.google.protobuf.ByteString
      getAmountBytes();
}
