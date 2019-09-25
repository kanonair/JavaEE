package io.kanonair.net;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class NetDemo {

    @Test
    public void client01() throws Exception {
        InetAddress address = InetAddress.getByName("192.168.1.119");
        Socket socket = new Socket(address, 3000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，我是客户端".getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(b)) != -1) {
            os.write(b, 0, len);
        }
        System.out.println(os);
        os.close();
        inputStream.close();
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
        OutputStream os = socket.getOutputStream();
        os.write("收到了".getBytes());
        os.close();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

    @Test
    public void client02() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        String str = "UPD";
        DatagramPacket datagramPacket = new DatagramPacket(
                str.getBytes(),
                0,
                str.getBytes().length,
                InetAddress.getByName("127.0.0.1"),
                3000);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

    @Test
    public void server02() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(3000);
        byte[] b = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(b, 0, b.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        datagramSocket.close();
    }

    @Test
    public void url() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://www.baidu.com").openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int code = connection.getResponseCode();
        if (code == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            System.out.println(outputStream);
            outputStream.close();
            inputStream.close();
        }
    }

}
