package SocketLearn;

import com.google.common.primitives.Bytes;
import org.testng.collections.Lists;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

/**
 * @program: QAproject
 * @description: 双向通信socket Client
 * @author: bjweiman
 * @create: 2019-05-09 16:22
 **/
public class MutualSocketClient {
    public static void main(String[] args) throws Exception{
        String host = "127.0.0.1";
        int port = 7778;

        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message="我是客户端，发送消息到服务端";
        outputStream.write(message.getBytes("GBK"));
        socket.shutdownOutput();


        System.out.println("客户端发送消息到服务端");
        InputStream inputStream = socket.getInputStream();
        int readByte;
        List<Byte> byteList = Lists.newArrayList();
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();

        while (inputStream != null){
            readByte = inputStream.read();
            byteList.add((byte)readByte);
            bytes = Bytes.toArray(byteList);
            sb.append(bytes);
            if (readByte == -1){
                break;
            }
        }

        System.out.println("收到服务端消息：" +  new String(bytes,"GBK"));

        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
