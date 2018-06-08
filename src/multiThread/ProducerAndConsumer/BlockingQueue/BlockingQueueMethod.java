package multiThread.ProducerAndConsumer.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * Created by Administrator on 2018/4/8.
 */
public class BlockingQueueMethod {
    public static void main(String[] args) throws InterruptedException {
        Storage storage=new Storage();
        Producer producer=new Producer(storage);
        Consumer customer=new Consumer(storage);
        new Thread(producer).start();
        new Thread(customer).start();
        Thread.sleep(3000);
        producer.stopsignal=0;
        customer.stopsignal=0;
    }
}
class Producer implements Runnable{
    Storage storage;
    volatile int stopsignal=1;
    public Producer(Storage storage){
        this.storage=storage;
    }
    @Override
    public void run(){
        try {
            while(stopsignal==1)
                storage.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    Storage storage;
    volatile int stopsignal=1;
    public Consumer(Storage storage){
        this.storage=storage;
    }
    @Override
    public void run(){
        try {
            while(stopsignal==1)
                storage.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Storage{
    private BlockingQueue queue=new LinkedBlockingQueue(10);
    private int MAXNUM=10;
    public void produce() throws InterruptedException{
        if(queue.size()==MAXNUM) {
            System.out.println("仓库满啦！");
        }
            queue.put(new Object());
            System.out.println("生产了一个商品，现有仓储量为"+queue.size());
    }
    public void consume() throws InterruptedException{
            if(queue.size()==0){
                System.out.println("仓库空啦！");
            }
            queue.take();
            System.out.println("消耗了一个商品，现有仓储量为"+queue.size());
    }
}
