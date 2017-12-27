package com.liangke.tcp.message;

import com.liangke.tcp.socket.SocketThreadManager;

/**
 * Created by LK on 2017/12/12.
 */

public class HandMessage {

    public static void sendHandMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] b = new byte[1];
                b[0] = -127;//握手
                SocketThreadManager.getInstance().sendMsg(b,null);
            }
        }).start();
    }

}
