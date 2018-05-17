package socketprogram.UDPtest;

import java.io.IOException;
import java.net.*;

/**
 * Created by Administrator on 2018/4/28.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress address=InetAddress.getLocalHost();
        byte data[]="我是客户端".getBytes();
        DatagramPacket packet=new DatagramPacket(data,data.length,address,8800);
        DatagramSocket socket=new DatagramSocket();
        socket.send(packet);
    }
}
