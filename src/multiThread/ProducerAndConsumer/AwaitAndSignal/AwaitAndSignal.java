package multiThread.ProducerAndConsumer.AwaitAndSignal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/4/8.
 */
public class AwaitAndSignal {
    public static void main(String[] args) {
        Storage storage=new Storage();
        new Thread(new Producer(storage)).start();
        new Thread(new Producer(storage)).start();
        new Thread(new Consumer(storage)).start();
        new Thread(new Producer(storage)).start();
        new Thread(new Producer(storage)).start();
        new Thread(new Consumer(storage)).start();
        new Thread(new Consumer(storage)).start();
        new Thread(new Producer(storage)).start();
    }
}
class Producer implements Runnable{
    Storage storage;
    public Producer(Storage storage){
        this.storage=storage;
    }
    @Override
    public void run(){
        try {
            storage.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable{
    Storage storage;
    public Consumer(Storage storage){
        this.storage=storage;
    }
    @Override
    public void run(){
        try {
            storage.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Storage{
    private LinkedList<Object> objectlist=new LinkedList<>();
    private int MAXNUM=5;
    private ReentrantLock lock=new ReentrantLock();
    private Condition full=lock.newCondition();
    private Condition empty=lock.newCondition();
    public void produce() throws InterruptedException {
        lock.lock();
        while(objectlist.size()==MAXNUM){
            System.out.println("仓库是满的！");
            full.await();
        }
        objectlist.add(new Object());
        System.out.println("生产了一个商品，现有仓储量为"+objectlist.size());
        full.signalAll();
        lock.unlock();
    }
    public void consume() throws InterruptedException {
        lock.lock();
        while(objectlist.size()==0){
            System.out.println("仓库是空的！");
            full.await();
        }
        objectlist.remove();
        System.out.println("消耗了一个商品，现有仓储量为"+objectlist.size());
        full.signalAll();
        lock.unlock();
    }
}


