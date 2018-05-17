package multiThread;

/**
 * Created by Administrator on 2018/5/17.
 */
public class DeadLockDemo {
    public static String A="A";
    public static String B="B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    public void deadLock(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(A){
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B){
                        System.out.println("T1");
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(B){
                    synchronized(A){
                        System.out.println("T2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
