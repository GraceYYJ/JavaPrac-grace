package socketprogram.TCPtest;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2018/4/28.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",8888);
            OutputStream os=socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            pw.write("用户名：yyj+密码:123456");
            pw.flush();
            socket.shutdownOutput();
            InputStream is=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            String info=null;
            while((info=br.readLine())!=null){
                System.out.println(info);
            }
            socket.shutdownInput();
            br.close();
            isr.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
