package multiThread;

/**
 * Created by Administrator on 2018/5/17.
 */
public class SynchronizedTest {
    public synchronized void A(int a) throws InterruptedException {
        System.out.println(a);
        Thread.sleep(5000);
    }
    /**
     *  A、B两个方法无法用两个线程同时执行；
        将B方法上的synchronized去掉则为非同步方法，可以和方法A同时执行
        为方法B加上static则为类同步方法，也可以和方法A同时执行
     */
    public synchronized void B(int b){
        System.out.println(b);
    }

    public static void main(String[] args) {
        final SynchronizedTest obj1=new SynchronizedTest();
        //线程t1
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj1.A(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //线程t2
        new Thread(new Runnable() {
            @Override
            public void run() {
                    obj1.B(2);
            }
        }).start();
    }
}
