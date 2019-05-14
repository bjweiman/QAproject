package SocketLearn;

import com.google.common.collect.Lists;
import com.google.common.primitives.Bytes;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @program: QAproject
 * @description: SocketServer
 * @author: bjweiman
 * @create: 2019-05-09 15:37
 **/
public class SocketServer {
    public static void main(String[] args) {
        int port = 7777;
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            //server将一直等待连接的到来
            System.out.println("server端已经启动，等待client链接！");
            Socket socket = serverSocket.accept();

            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream inputStream = socket.getInputStream();
            byte[] receiveData = new byte[1024];
            List<Byte> bytes = Lists.newArrayList();

            int readByte;
            StringBuilder stringBuilder = new StringBuilder();

            while (inputStream != null){
                readByte = inputStream.read();
                bytes.add((byte)readByte);
                receiveData = Bytes.toArray(bytes);
                stringBuilder.append(receiveData);
//                System.out.println("从客户端接收到数据：" + receiveData);
                if (readByte == -1){
                    break;
                }
            }
            new String(receiveData,"UTF-8");
            System.out.println("从客户端接收到数据：" +  new String(receiveData,"UTF-8"));
            inputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
