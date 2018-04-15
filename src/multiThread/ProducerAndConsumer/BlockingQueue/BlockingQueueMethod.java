package multiThread.ProducerAndConsumer.BlockingQueue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2018/4/8.
 */
public class BlockingQueueMethod {
    public static void main(String[] args) {
        Storage storage=new Storage();
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
    private BlockingQueue queue=new LinkedBlockingDeque(10);
    private int MAXNUM=10;
    public void produce() throws InterruptedException{
        if(queue.size()==MAXNUM){
            System.out.println("仓库满啦！");
        }
        queue.put(new Object());
        System.out.println("生产了一个商品，现有仓储量为"+queue.size());
    }
    public void consume() throws InterruptedException{
        if(queue.size()==0){
            System.out.println("仓库空啦！");
        }
        queue.remove();
        System.out.println("消耗了一个商品，现有仓储量为"+queue.size());
    }
}
