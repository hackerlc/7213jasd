package com.liangke.tcp.socket;


import com.liangke.comprehensive.main.MyApplication;
import com.liangke.tcp.domain.TCPConstants;
import com.liangke.tcp.message.ReceiveMessage;
import com.liangke.utils.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;


/**
 * Created by yangcaihao on 16/6/3.
 * update by ych on 17/2/20
 */
public class SocketInputThread extends Thread {
    private boolean isStart = true;

    private static String TAG = "TCP";

    private ReceiveMessage receiveMessage;

    // private MessageListener messageListener;// 消息监听接口对象

    public SocketInputThread() {

        receiveMessage = new ReceiveMessage();

    }

    public void setStart(boolean isStart) {
        this.isStart = isStart;
    }

    @Override
    public void run() {
        while (isStart) {
            if (Utils.isNetworkConnected(MyApplication.application)) {

                if (TCPClient.getInstance() == null ||!TCPClient.getInstance().isConnect()) {

                    try {
                        sleep(TCPConstants.SLEEP_SECONDS * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                readSocket();

                // 如果连接服务器失败,服务器连接失败，sleep固定的时间，能联网，就不需要sleep

//                Log.e("socket", "TCPClient.instance().isConnect() " + TCPClient.getInstance().isConnect());


            }
        }
    }

    public void readSocket() {
        Selector selector = TCPClient.getInstance().getSelector();
        if (selector == null) {
            return;
        }
        try {
            // 如果没有数据过来，一直柱塞
            while (selector.select() > 0) {
                for (SelectionKey sk : selector.selectedKeys()) {
                    // 如果该SelectionKey对应的Channel中有可读的数据
                    if (sk.isReadable()) {
                        // 使用NIO读取Channel中的数据
                        SocketChannel sc = (SocketChannel) sk.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //实际的读取流
                        ByteArrayOutputStream read = new ByteArrayOutputStream();
                        int nRead = 0;
                        int nLen = 0;
                        //单个读取流
                        byte[] bytes = null;
                        //读完为止
                        while ((nRead = sc.read(buffer)) > 0) {
                            //整理
                            buffer.flip();
                            bytes = new byte[nRead];
                            nLen += nRead;
                            //将读取的数据拷贝到字节流中
                            buffer.get(bytes);
                            //将字节流添加到实际读取流中
                            read.write(bytes);
                            /////////////////////////////////////
                            //@ 需要增加一个解析器,对数据流进行解析

                            /////////////////////////////////////

                            buffer.clear();
                        }
                        buffer = null;

                        receiveMessage.dispatchMessage(bytes);

                        try {
                            // 为下一次读取作准备
                            sk.interestOps(SelectionKey.OP_READ);
                            // 删除正在处理的SelectionKey
                            selector.selectedKeys().remove(sk);

                        } catch (CancelledKeyException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ClosedSelectorException e2) {
        } catch (CancelledKeyException e3) {
            e3.printStackTrace();
        }
    }



}