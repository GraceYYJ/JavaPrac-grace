package multiThread;

/**
 * Created by Administrator on 2018/5/17.
 */
public class SynchronizedTest2 {
    public static synchronized void A(int a) throws InterruptedException {
        System.out.println(a);
        Thread.sleep(5000);
    }
    /**
     *  A、B两个方法无法用两个线程同时执行；
        将B方法上的static去掉则为普通同步方法，也可以和方法A同时执行
     */
    public static synchronized void B(int b){
        System.out.println(b);
    }
    public static void main(String[] args) {
        //线程t1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SynchronizedTest2.A(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //线程t2
        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedTest2.B(2);
            }
        }).start();
    }
}
