package socketprogram.TCPtest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2018/4/28.
 */
public class Server {
    public static void main(String[] args) {
        Socket socket=null;
        int count =0;
        try {
            ServerSocket serverSocket=new ServerSocket(8888);
            while(true){
                socket=serverSocket.accept();
                ServerThread st=new ServerThread(socket);
                Thread thread=new Thread(st);
                thread.start();
                count++;
                System.out.println("客户端数量"+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
