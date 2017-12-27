package com.liangke.tcp.domain;

import android.os.Handler;

/**
 * Created by yangcaihao on 16/6/3.
 */
public class MsgEntity {
    private byte[] bytes;
    private Handler handler;
    public MsgEntity(byte[] bytes, Handler handler){
        this.bytes = bytes;
        this.handler = handler;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
