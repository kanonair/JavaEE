package io.kanonair.net;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetDemo {

    @Test
    public void client01() throws Exception {
        InetAddress address = InetAddress.getByName("192.168.1.119");
        Socket socket = new Socket(address, 3000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，我是客户端".getBytes());
        outputStream.close();
        socket.close();
    }

    @Test
    public void server01() throws Exception {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        ByteOutputStream outputStream = new ByteOutputStream();
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, len);
        }
        System.out.println(outputStream);
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

}
