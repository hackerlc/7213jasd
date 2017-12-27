package com.liangke.tcp.socket;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.liangke.tcp.domain.MsgEntity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by yangcaihao on 16/6/3.
 */
public class SocketOutputThread extends Thread {
    private boolean isStart = true;
    private static String tag = "TCP";
    private List<MsgEntity> sendMsgList;

    public SocketOutputThread( )
    {

        sendMsgList = new CopyOnWriteArrayList<MsgEntity>();
    }

    public void setStart(boolean isStart)
    {
        this.isStart = isStart;
        synchronized (this)
        {
            notify();
        }
    }

    // 使用socket发送消息
    public boolean sendMsg(byte[] msg) throws Exception
    {

        if (msg == null)
        {
            Log.e(tag, "sendMsg is null");
            return false;
        }

        try
        {
            TCPClient.getInstance().sendMsg(msg);

        } catch (Exception e)
        {
            throw (e);
        }

        return true;

    }

    // 使用socket发送消息
    public void addMsgToSendList(MsgEntity msg)
    {
        synchronized (this)
        {
            this.sendMsgList.add(msg);
            notify();
        }
    }

    @Override
    public void run()
    {
        while (isStart)
        {
            // 锁发送list
            synchronized (sendMsgList)
            {
                // 发送消息
                for (MsgEntity msg : sendMsgList)
                {
                    Handler handler = msg.getHandler();
                    try
                    {
                        sendMsg(msg.getBytes());
                        sendMsgList.remove(msg);
                        // 成功消息，通过hander回传
                        if (handler != null)
                        {
                            Message message =  new Message();
                            message.obj = msg.getBytes();
                            message.what =1;
                            handler.sendMessage(message);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                       Log.e(tag, e.toString());
                        // 错误消息，通过hander回传
                        if (handler != null)
                        {
                            Message message =  new Message();
                            message.obj = msg.getBytes();
                            message.what = 0;
                            handler.sendMessage(message);

                        }
                    }
                }
            }

            synchronized (this)
            {
                try
                {
                    wait();

                } catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }// 发送完消息后，线程进入等待状态
            }
        }

    }
}
