package com.liangke.tcp.message;

import com.liangke.tcp.domain.MessageUtils;
import com.liangke.tcp.packet.Command;
import com.liangke.tcp.packet.CommodityType;
import com.liangke.tcp.packet.QuoteReqBody;
import com.liangke.tcp.packet.QuoteType;
import com.liangke.tcp.socket.SocketThreadManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LK on 2017/12/15.
 * 订阅行情
 */

public class SubscribeMessage {

     public static class Subscribe{
          String commdity;
          String productId;

          public Subscribe(String commdity, String productId) {
               this.commdity = commdity;
               this.productId = productId;
          }
     }

     public static void sendSubscribeMessage(String commdity,String productId){
          QuoteReqBody.Builder builder = QuoteReqBody.newBuilder();
          builder.setTime(System.currentTimeMillis());

          CommodityType.Builder typeBuilder = CommodityType.newBuilder();
          typeBuilder.setCommodityNo(commdity);
          typeBuilder.setProductId(productId);
          CommodityType commodityType = typeBuilder.build();


          List<CommodityType> typeList = new ArrayList<>();
          typeList.add(commodityType);
          builder.addAllCommodityType(typeList);

          QuoteReqBody body = builder.build();

          SocketThreadManager.getInstance().sendMsg(MessageUtils.getPacket(body.toByteArray(), Command.COMMAND_QUOTE_ADD_REQ_VALUE),null);

     }


     public static void sendSubscribeMessage(List<Subscribe> commdityList){
          if(commdityList==null||commdityList.size()==0){
               return;
          }
          QuoteReqBody.Builder builder = QuoteReqBody.newBuilder();
          builder.setTime(System.currentTimeMillis());

          List<CommodityType> typeList = new ArrayList<>();
          for(int i = 0;i<commdityList.size();i++){
               CommodityType.Builder typeBuilder = CommodityType.newBuilder();
               typeBuilder.setCommodityNo(commdityList.get(i).commdity);
               typeBuilder.setProductId(commdityList.get(i).productId);
               typeBuilder.setContractNo("");
               CommodityType commodityType = typeBuilder.build();
               typeList.add(commodityType);
          }
          builder.addAllCommodityType(typeList);

          QuoteReqBody body = builder.build();

          SocketThreadManager.getInstance().sendMsg(MessageUtils.getPacket(body.toByteArray(), Command.COMMAND_QUOTE_ADD_REQ_VALUE),null);

     }




}
