package socketprogram.TCPtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2018/4/28.
 */
public class Testsocket {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address=InetAddress.getLocalHost();
        System.out.println(address.getHostName()+" "+address.getHostAddress());
        try {
            URL url=new URL("http://www.baidu.com");
            //获取一个输入流
            InputStream is=url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            //为字符输入流添加缓冲
            BufferedReader br=new BufferedReader(isr);
            String data=br.readLine();
            while(data!=null){
                System.out.println(data);
                data=br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
