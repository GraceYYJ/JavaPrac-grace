package socketprogram.UDPtest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Administrator on 2018/4/28.
 */
public class Server {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket=new DatagramSocket(8800);
        byte[] data=new byte[1024];
        DatagramPacket packet=new DatagramPacket(data,data.length);
        socket.receive(packet);
        String info=new String(data,0,packet.getLength());
        System.out.println(info);
    }
}
