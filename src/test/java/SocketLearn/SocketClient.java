package SocketLearn;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: QAproject
 * @description: SocketClient
 * @author: bjweiman
 * @create: 2019-05-09 15:24
 **/
public class SocketClient {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 7777;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message="我是客户端，现在发送消息";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }
}
