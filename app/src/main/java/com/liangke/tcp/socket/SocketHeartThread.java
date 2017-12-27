package com.liangke.tcp.socket;


import android.util.Log;

import com.liangke.tcp.domain.TCPConstants;
import com.liangke.tcp.message.HeartMessage;

/**
 * Created by yangcaihao on 16/6/3.
 */
public class SocketHeartThread extends Thread {
    private static final String TAG = TCPConstants.TAG;

    private boolean isStop = false;


    public SocketHeartThread() {

    }

    public void run() {

        while (!isStop){
            // 发送一个心跳包看服务器是否正常

            try {
                Thread.sleep(5 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(TCPClient.getInstance().isAuth()){
                HeartMessage.sendHeartMessage();
            }

        }
    }

    public void stopThread(){
        isStop = true;
    }

}
