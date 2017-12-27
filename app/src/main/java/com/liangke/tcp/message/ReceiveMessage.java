package com.liangke.tcp.message;

import android.util.Log;

import com.google.protobuf.InvalidProtocolBufferException;
import com.liangke.tcp.event.QuoteRequestEvent;
import com.liangke.tcp.packet.AuthRespBody;
import com.liangke.tcp.packet.AuthResult;
import com.liangke.tcp.packet.Command;
import com.liangke.tcp.packet.QuoteRealPushBody;
import com.liangke.tcp.packet.QuoteReqBody;
import com.liangke.tcp.packet.QuoteRespBody;
import com.liangke.tcp.socket.SocketThreadManager;
import com.liangke.tcp.socket.TCPClient;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LK on 2017/12/12.
 */

public class ReceiveMessage {

    private final String TAG = "TCP";

    public void dispatchMessage(byte[] bytes){

        Log.i(TAG,">>收到消息:"+(bytes.length>2?bytes[1]:""));

        if(bytes==null){
            return;
        }

        if(bytes.length==1){
            if(bytes[0]==-127){
                //握手
                Log.i(TAG,"握手成功");
//                AuthMessage.sendAuthReqMessage();
            }else if(bytes[0]==-128){
                //心跳
                Log.i(TAG,"心跳");
            }
        }else{

            try {

            byte command = bytes[1];
            if(command== Command.COMMAND_AUTH_RESP_VALUE){
                //鉴权相应

                    AuthRespBody body = null;
                    body = AuthRespBody.parseFrom(getBodyBytes(bytes));
                    if(body.getResult()== AuthResult.AUTH_RESULT_OK){
                        Log.i("TCP","鉴权成功");
                        TCPClient.getInstance().setAuth(true);
                    }


            }else if(command==Command.COMMAND_QUOTE_REAL_PUSH_VALUE){

                QuoteRealPushBody body = QuoteRealPushBody.parseFrom(getBodyBytes(bytes));
                Log.i(TAG,"bid=="+body.getBid());
                List<QuoteRealPushBody> bodyList = new ArrayList<>();
                bodyList.add(body);
                EventBus.getDefault().post(new QuoteRequestEvent((ArrayList<QuoteRealPushBody>) bodyList));


            }

            } catch (Exception e) {
                e.printStackTrace();
                Log.i(TAG,"InvalidProtocolBufferException=="+e.getMessage());
            }

        }

    }


    private byte[] getHeaderBytes(byte[] bytes) {
        byte[] header = new byte[5];
        if (bytes != null && bytes.length > 0) {

            System.arraycopy(bytes, 0, header, 0, 5);
            StringBuilder sb = new StringBuilder();
            for (byte headByte :
                    header) {
                sb.append(headByte + "-");

            }
        }
        return header;
    }

    private byte[] getBodyBytes(byte[] bytes){
        short length = (short)(((bytes[7] & 0x00FF) << 8) | (0x00FF & bytes[8]));
        byte[] data = new byte[length];
        System.arraycopy(bytes, 9, data, 0, length);
        return data;
    }

}
