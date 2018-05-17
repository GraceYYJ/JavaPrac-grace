package socketprogram.TCPtest;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2018/4/28.
 */
public class ServerThread implements Runnable {
    Socket socket;
    public ServerThread(Socket socket){
        this.socket=socket;
    }
    public void run(){
        InputStream is= null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        String info=null;
        OutputStream os=null;
        PrintWriter pw=null;
        try {
            is = socket.getInputStream();
            isr=new InputStreamReader(is);
            br=new BufferedReader(isr);
            while((info=br.readLine())!=null){
                System.out.println("客户端信息"+info);
            }
            os=socket.getOutputStream();
            pw=new PrintWriter(os);
            pw.write("收到啦，登陆成功");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pw.close();
                os.close();
                br.close();
                isr.close();
                is.close();
                //socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
