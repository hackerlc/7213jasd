package com.liangke.tcp.domain;

import java.nio.ByteBuffer;

/**
 * Created by LK on 2017/12/15.
 */

public class MessageUtils {

    public static byte[] getPacket(byte[] bodyArray,int command){

        int alllen = 9 + bodyArray.length;
        ByteBuffer byteBuffer = ByteBuffer.allocate(alllen);

        byteBuffer.put((byte) 1);//版本号
        byteBuffer.put((byte) command);//命令
        byteBuffer.put((byte) 0);//是否压缩
        byteBuffer.putInt(0);
        byteBuffer.putShort((short)bodyArray.length);
        byteBuffer.put(bodyArray);

        return byteBuffer.array();

    }

}
