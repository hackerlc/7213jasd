package com.liangke.tcp.socket;




import android.util.Log;

import com.liangke.constants.Constants;
import com.liangke.tcp.domain.TCPConstants;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Arrays;


/**
 * Created by yangcaihao on 16/6/3.
 */
public class TCPClient {
    private static final String TAG = "TCP";
    /**
     * 信道选择器
     */
    private Selector mSelector;
    /**
     * 通信的信道
     */
    private SocketChannel mSocketChannel;
    /**
     * 服务器ip地址
     */
    private String mRemoteIp;
    private InetAddress mRemoteAddress;
    /**
     * 端口号
     */
    private int mPort;
    private static TCPClient mTcp = null;
    public boolean isInitialized = false;

    /**
     *是否鉴权成功
     */
    private boolean isAuth=false;



    public static  TCPClient getInstance() {
        if (mTcp == null) {
            synchronized (TCPClient.class){
                if (mTcp==null){
                    mTcp = new TCPClient(Constants.TCPHOST, Constants.PORT);
                }
            }
        }
        return mTcp;
    }

    private TCPClient(String host, int port) {
        try {
            mRemoteAddress = InetAddress.getByName(host);
            mRemoteIp = mRemoteAddress.getHostAddress();
            mPort = port;
            init();

            isInitialized = true;
        } catch (Exception e) {
            isInitialized = false;
            e.printStackTrace();
            Log.i(TAG,"init Exception=="+e.getMessage());
        }

    }

    /**
     * 初始化
     *
     * @throws IOException
     */
    private void init() throws IOException {
        Log.i(TAG,">>>>==init");
        boolean done = false;
        try {
            mSocketChannel = SocketChannel.open(new InetSocketAddress(mRemoteAddress, mPort));
            if (mSocketChannel != null) {
                mSocketChannel.socket().setTcpNoDelay(false);
                mSocketChannel.socket().setKeepAlive(true);
                //设置 读socket的timeout时间
                mSocketChannel.socket().setSoTimeout(TCPConstants.TIME_OUT);
                mSocketChannel.configureBlocking(false);
                //打开并注册选择器到信道
                mSelector = Selector.open();
                if (mSelector != null) {
                    mSocketChannel.register(mSelector, SelectionKey.OP_READ);
                    done = true;

                }
            }

        } finally {
            if (!done && mSelector != null) {
                mSelector.close();
            }
            if (!done) {
                mSocketChannel.close();
            }
        }
    }

    static void blockUntil(SelectionKey key, long timeout) throws IOException {

        int nkeys = 0;
        if (timeout > 0) {
            nkeys = key.selector().select(timeout);

        } else if (timeout == 0) {
            nkeys = key.selector().selectNow();
        }

        if (nkeys == 0) {
            throw new SocketTimeoutException();
        }
    }

    /**
     * 发送字符串到服务器
     *
     * @param message
     * @throws IOException
     */
    public void sendMsg(String message) throws IOException {
        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("utf-8"));

        if (mSocketChannel == null) {
            throw new IOException();
        }
        mSocketChannel.write(writeBuffer);
    }



    public boolean heart(){
        boolean isConnect=true;
        try{
            byte[] heartBytes = new byte[]{-128};
            sendMsg(heartBytes);
        }catch (Exception e){
            e.printStackTrace();
            isConnect = false;

        }finally {
            return isConnect;
        }
    }

    /**
     * 发送数据
     *
     * @param bytes
     * @throws IOException
     */
    public void sendMsg(byte[] bytes) throws IOException {
        ByteBuffer writeBuffer = ByteBuffer.wrap(bytes);

        if (mSocketChannel == null) {
            throw new IOException();
        }

        mSocketChannel.write(writeBuffer);
        writeBuffer.clear();

        Log.i("TCP","发送："+ Arrays.toString(writeBuffer.array()));

    }

    /**
     * @return
     */
    public synchronized Selector getSelector() {
        return this.mSelector;
    }

    /**
     * Socket连接是否是正常的
     *
     * @return
     */
    public boolean isConnect() {
        boolean isConnect = false;
        if (this.isInitialized) {
            isConnect = this.mSocketChannel.isConnected();
        }
        return isConnect;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    /**
     * 关闭socket 重新连接
     *
     * @return
     */
    public boolean reConnect() {
        closeTCPSocket();

        try {
            init();
            isInitialized = true;
        } catch (IOException e) {
            isInitialized = false;
            e.printStackTrace();
        } catch (Exception e) {
            isInitialized = false;
            e.printStackTrace();
        }
        return isInitialized;
    }

    /**
     * 服务器是否关闭，通过发送一个socket信息
     *
     * @return
     */
    public boolean canConnectToServer() {
        try {
            if (mSocketChannel != null) {
                //// TODO: 16/6/21  
                mSocketChannel.socket().sendUrgentData(0xff);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 关闭socket
     */
    public void closeTCPSocket() {
        try {
            if (mSocketChannel != null) {
                mSocketChannel.close();
            }

        } catch (IOException e) {

        }
        try {
            if (mSelector != null) {
                mSelector.close();
            }
        } catch (IOException e) {
        }
    }

    /**
     * 每次读完数据后，需要重新注册selector，读取数据
     */
    public synchronized void repareRead() {
        if (mSocketChannel != null) {
            try {
                mSelector = Selector.open();
                mSocketChannel.register(mSelector, SelectionKey.OP_READ);
            } catch (ClosedChannelException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
