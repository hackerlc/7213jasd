package com.liangke.tcp.message;

import android.util.Log;

import com.liangke.tcp.domain.TCPConstants;
import com.liangke.tcp.socket.SocketThreadManager;
import com.liangke.tcp.socket.TCPClient;

import java.io.IOException;

/**
 * Created by LK on 2017/12/12.
 */

public class HeartMessage {

    public static void sendHeartMessage(){
        byte[] heartBytes = new byte[1];
        heartBytes[0] = -128;
        SocketThreadManager.getInstance().sendMsg(heartBytes,null);
    }

}
