package multiThread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1号线程ok");
                //该方法使计数器值-1
                c.countDown();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2号线程ok");
                //该方法使计数器值-1
                c.countDown();
            }
        });
        t1.start();
        t2.start();
        //await()方法会阻塞当前线程，直到计数器值为0
        c.await();
        System.out.print("主线程已经等到t1和t2都执行完毕");
    }
}
