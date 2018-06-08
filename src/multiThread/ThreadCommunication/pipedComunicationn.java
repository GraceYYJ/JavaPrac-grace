package multiThread.ThreadCommunication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/5/18.
 */
public class pipedComunicationn {
    public static void main(String[] args) throws IOException {
        PipedWriter out=new PipedWriter();
        PipedReader in=new PipedReader();
        out.connect(in);
        int receive=0;
        Thread printThread=new Thread(new Print(in));
        printThread.start();
        System.out.println("主线程接收控制台输入的信息");
        while((receive=System.in.read())!=-1){
            out.write(receive);
        }
        out.close();
        Lock lock=new ReentrantLock();

    }
}
class Print implements Runnable{
    private PipedReader in;
    public Print(PipedReader in){
        this.in=in;
    }
    public void run(){
        int receive=0;
        try {
            System.out.println("我是print线程，输出我从管道接收到的信息：");
            while((receive=in.read())!=-1){
                System.out.print((char)receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
