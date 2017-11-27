package leetcode;

/**
 * Created by Administrator on 2017/7/19.
 */
public class TestThread extends Thread{
    @Override
    public void run(){
        super.run();
        System.out.println("TestThread");
    }
    public static void main(String args[]){
        TestThread tt =new TestThread();
        tt.start();
        System.out.println(Thread.currentThread().getName());
    }
}
