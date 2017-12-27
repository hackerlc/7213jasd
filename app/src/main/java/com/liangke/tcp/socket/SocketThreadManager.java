package com.liangke.tcp.socket;

import android.os.Handler;

import com.liangke.tcp.domain.MsgEntity;

/**
 * Created by yangcaihao on 16/6/3.
 */
public class SocketThreadManager {
    private static SocketThreadManager s_SocketManager = null;

    private SocketInputThread mInputThread = null;

    private SocketOutputThread mOutThread = null;

    private SocketHeartThread mHeartThread = null;


    // 获取单例
    public static SocketThreadManager getInstance()
    {
        if (s_SocketManager == null)
        {
            s_SocketManager = new SocketThreadManager();
            s_SocketManager.startThreads();
        }
        return s_SocketManager;
    }

    // 单例，不允许在外部构建对象
    private SocketThreadManager()
    {
        mHeartThread = new SocketHeartThread();
        mInputThread = new SocketInputThread();
        mOutThread = new SocketOutputThread();
    }

    /**
     * 启动线程
     */

    private void startThreads()
    {

        mInputThread.start();
        mInputThread.setStart(true);
        mOutThread.start();
        mOutThread.setStart(true);
        mHeartThread.start();

        // mDnsthread.start();
    }
    public void startHeartThread(){

            mHeartThread.start();


    }
    /**
     * stop线程
     */
    public void stopThreads()
    {
        mHeartThread.stopThread();
        mInputThread.setStart(false);
        mOutThread.setStart(false);
    }
    public void checkThread(){
//        if (mHeartThread==null){
//            mHeartThread = new SocketHeartThread();
//        }
//        if (mHeartThread.isStop){
//            mHeartThread.start();
//        }
//        if (mInputThread==null){
//            mInputThread = new SocketInputThread();
//        }
//        if (!mInputThread.isAlive()){
//            mInputThread.start();
//            mInputThread.setStart(true);
//        }
//        if (mOutThread==null){
//            mOutThread = new SocketOutputThread();
//            mOutThread.start();
//            mOutThread.setStart(true);
//        }
//        if (!mOutThread.isAlive()){
//            mOutThread.start();
//            mOutThread.setStart(true);
//        }
    }

    public static void releaseInstance()
    {
        if (s_SocketManager != null)
        {
            s_SocketManager.stopThreads();
            s_SocketManager = null;
        }
    }

    public void sendMsg(byte [] buffer, Handler handler)
    {
        MsgEntity entity = new MsgEntity(buffer, handler);
        mOutThread.addMsgToSendList(entity);
    }

}
