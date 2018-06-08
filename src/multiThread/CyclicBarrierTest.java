package multiThread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest implements Runnable{
    @Override
    public void run() {
        System.out.println("我是barrierAction，先要执行我");
    }
    //构造方法里规定需要到达屏障的线程数为2
    static CyclicBarrier c=new CyclicBarrier(2,new CyclicBarrierTest());

    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1号达到屏障");
                try {
                    //用该方法告知c我已经到达屏障，然后阻塞，直到最后一个线程也到达；
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2号达到屏障");
                try {
                    //用该方法告知c我已经到达屏障，然后阻塞，直到最后一个线程也到达；
                    c.await();
                    System.out.println("继续运行啦");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.start();
    }
}
