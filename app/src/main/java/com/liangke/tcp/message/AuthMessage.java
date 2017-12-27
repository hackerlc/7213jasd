package com.liangke.tcp.message;

import android.util.Log;

import com.liangke.tcp.domain.MessageUtils;
import com.liangke.tcp.domain.TCPConstants;
import com.liangke.tcp.packet.AuthReqBody;
import com.liangke.tcp.packet.Command;
import com.liangke.tcp.packet.DeviceType;
import com.liangke.tcp.socket.SocketThreadManager;

import java.nio.ByteBuffer;

/**
 * Created by LK on 2017/12/12.
 */

public class AuthMessage {
    private static final String TAG = TCPConstants.TAG;
    public static void sendAuthReqMessage(){
        Log.i(TAG,"发送鉴权包");
        AuthReqBody.Builder builder = AuthReqBody.newBuilder();
        builder.setTime(System.currentTimeMillis());
        builder.setDeviceId("2");
        builder.setToken("1");
        builder.setDeviceType(DeviceType.DEVICE_TYPE_ANDROID);
        builder.setDeviceTypeValue(DeviceType.DEVICE_TYPE_ANDROID_VALUE);
        builder.setCid("1");
        builder.setAppVersion("1");
        builder.setDeviceInfo("7");
        builder.setSeq(6);
        builder.setSign("1111");
        AuthReqBody body = builder.build();

        int alllen = 9 + body.toByteArray().length;
        ByteBuffer byteBuffer = ByteBuffer.allocate(alllen);

        byteBuffer.put((byte) 1);//版本号
        byteBuffer.put((byte) 3);//命令
        byteBuffer.put((byte) 0);//是否压缩
        byteBuffer.putInt(0);
        byteBuffer.putShort((short)body.toByteArray().length);
        byteBuffer.put(body.toByteArray());


        SocketThreadManager.getInstance().sendMsg(MessageUtils.getPacket(body.toByteArray(), Command.COMMAND_AUTH_REQ_VALUE),null);
    }

}
