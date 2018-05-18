package multiThread.ThreadCommunication;

/**
 * Created by Administrator on 2018/5/18.
 */
public class waitAndNotify {
    public static Object obj=new Object();
    public static volatile boolean flag=false;
    public static void main(String[] args) throws InterruptedException{
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("t1获得锁");
                    while(!flag){
                        try {
                            System.out.println("t1通过调用wait()方法释放锁");
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("flag=true，t1结束等待");
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("t2获得锁");
                    flag=true;
                    obj.notify();//这个方法不会释放锁，但会在后面释放锁后通知t1
                    System.out.println("t2通过notify()方法来通知t1");
                }
                System.out.println("同步块结束，t2释放锁");
            }
        });
        t1.start();
        Thread.sleep(3000);
        t2.start();
    }
}
