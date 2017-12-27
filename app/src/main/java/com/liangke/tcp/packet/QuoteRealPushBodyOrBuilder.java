// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.liangke.tcp.packet;

public interface QuoteRealPushBodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.liangke.tcp.packet.QuoteRealPushBody)
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
   *行情时间,时间戳
   * </pre>
   *
   * <code>int64 ctm = 5;</code>
   */
  long getCtm();

  /**
   * <pre>
   *昨日收盘价
   * </pre>
   *
   * <code>string close = 6;</code>
   */
  String getClose();
  /**
   * <pre>
   *昨日收盘价
   * </pre>
   *
   * <code>string close = 6;</code>
   */
  com.google.protobuf.ByteString
      getCloseBytes();

  /**
   * <pre>
   *今日开盘
   * </pre>
   *
   * <code>string open = 7;</code>
   */
  String getOpen();
  /**
   * <pre>
   *今日开盘
   * </pre>
   *
   * <code>string open = 7;</code>
   */
  com.google.protobuf.ByteString
      getOpenBytes();

  /**
   * <pre>
   *今日最高
   * </pre>
   *
   * <code>string high = 8;</code>
   */
  String getHigh();
  /**
   * <pre>
   *今日最高
   * </pre>
   *
   * <code>string high = 8;</code>
   */
  com.google.protobuf.ByteString
      getHighBytes();

  /**
   * <pre>
   *今日最低
   * </pre>
   *
   * <code>string low = 9;</code>
   */
  String getLow();
  /**
   * <pre>
   *今日最低
   * </pre>
   *
   * <code>string low = 9;</code>
   */
  com.google.protobuf.ByteString
      getLowBytes();

  /**
   * <pre>
   *结算涨跌幅,涨跌率的基本价格(期货是结算价,股票是收市价,放入这个字段)
   * </pre>
   *
   * <code>string settle = 10;</code>
   */
  String getSettle();
  /**
   * <pre>
   *结算涨跌幅,涨跌率的基本价格(期货是结算价,股票是收市价,放入这个字段)
   * </pre>
   *
   * <code>string settle = 10;</code>
   */
  com.google.protobuf.ByteString
      getSettleBytes();

  /**
   * <pre>
   *基准卖价,实时价
   * </pre>
   *
   * <code>string bid = 11;</code>
   */
  String getBid();
  /**
   * <pre>
   *基准卖价,实时价
   * </pre>
   *
   * <code>string bid = 11;</code>
   */
  com.google.protobuf.ByteString
      getBidBytes();

  /**
   * <pre>
   *买涨量
   * </pre>
   *
   * <code>string bidQty = 12;</code>
   */
  String getBidQty();
  /**
   * <pre>
   *买涨量
   * </pre>
   *
   * <code>string bidQty = 12;</code>
   */
  com.google.protobuf.ByteString
      getBidQtyBytes();

  /**
   * <pre>
   *基准买价
   * </pre>
   *
   * <code>string ask = 13;</code>
   */
  String getAsk();
  /**
   * <pre>
   *基准买价
   * </pre>
   *
   * <code>string ask = 13;</code>
   */
  com.google.protobuf.ByteString
      getAskBytes();

  /**
   * <pre>
   *买跌量
   * </pre>
   *
   * <code>string askQty = 14;</code>
   */
  String getAskQty();
  /**
   * <pre>
   *买跌量
   * </pre>
   *
   * <code>string askQty = 14;</code>
   */
  com.google.protobuf.ByteString
      getAskQtyBytes();

  /**
   * <pre>
   *点差 外汇用字段
   * </pre>
   *
   * <code>string mid = 15;</code>
   */
  String getMid();
  /**
   * <pre>
   *点差 外汇用字段
   * </pre>
   *
   * <code>string mid = 15;</code>
   */
  com.google.protobuf.ByteString
      getMidBytes();
}