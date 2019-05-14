package SocketLearn;

import com.google.common.primitives.Bytes;
import org.testng.collections.Lists;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @program: QAproject
 * @description: MutualSocketServer 双向通信server
 * @author: bjweiman
 * @create: 2019-05-09 16:23
 **/
public class MutualSocketServer {
    public static void main(String[] args) throws Exception{
        int port = 7778;

        ServerSocket serverSocket = new ServerSocket(port);

        Socket socket = serverSocket.accept();
        System.out.println("服务端等待客户端连接");

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        int byteReade;
        List<Byte> byteList = Lists.newArrayList();
        byte[] receiveData = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();


        while (inputStream != null){
            byteReade = inputStream.read();
            byteList.add((byte)byteReade);
            receiveData = Bytes.toArray(byteList);
            stringBuilder.append(receiveData);

            if (byteReade == -1){
                break;
            }
        }
        System.out.println("收到客户端消息：" +  new String(receiveData,"GBK"));

        String msg = "我是服务端，正在给客户端发送消息";
        outputStream.write(msg.getBytes("GBK"));

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();


    }
}
