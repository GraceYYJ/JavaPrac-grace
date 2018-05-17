package interview.designmode;

/**
 * Created by Administrator on 2018/4/11.
 * 单例模式，属于创建式模式。
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 场景：任务管理器、计数器、数据库连接池等，还有spring中默认bean都是单例的。
 */
public class Singleton{
    //单例模式多种实现
    public static void main(String[] args) {
    }
}
/**
 * 懒汉式单例（线程安全/不安全），要用的时候才初始化；
 * 根据初始化的getInstance方法是否上锁保证是否线程安全。
 */
class Singletonlazy{
    private static Singletonlazy instance;
    private Singletonlazy(){}
    //不加sychronized是基本懒汉式，加了是线程安全懒汉式
    public static synchronized Singletonlazy getInstance(){
        if(instance==null)
            instance=new Singletonlazy();
        return instance;
    }
}
/**
 * 饿汉式，类加载时就初始化，浪费堆内存；
 * 线程安全，因为该类在加载时，就会去初始化静态成员，并且类加载过程是线程安全的，一个类只会被加载一次。
 */
class Singletonhungry{
    private static Singletonhungry instance=new Singletonhungry();
    private Singletonhungry(){}
    public Singletonhungry getInstance(){
        return instance;
    }
}
/**
 * 双检锁式：先判断是否为空，再加锁,然后再判断，再初始化。（懒加载，线程安全）
 */
//双检锁式：先判断是否为空，再加锁,然后再判断，再初始化。（懒加载，线程安全）
/*为什么要用volatile？
instance = new Singleton()并非是一个原子操作，涉及到分配堆内存、调用构造函数、将instance指向分配的内存等操作。
jvm底层的指令重排序优化可能会将上面的操作指令重排，线程1可能导致instance不为空，但并未进行构造函数初始化，而引起线程2获取到这样的instance而报错。
所以要给instance加上volatile修饰，因为volatile除了保证可见性这一点外，还能禁止指令重排序；
使用volatile修饰的变量的赋值操作后面底层会加上一个StoreLoad内存屏障，使得读操作不会被重排序到内存屏障之前。*/
class SingletonDoublelock{
    private volatile static SingletonDoublelock instance;
    private SingletonDoublelock(){}
    public static SingletonDoublelock getInstance(){
        if(instance==null){
            synchronized (SingletonDoublelock.class){
                if(instance==null)
                    instance=new SingletonDoublelock();
            }
        }
        return instance;
    }
}
//内部类式，延迟加载且线程安全
//和饿汉式类似，但内部类方式可以实现延迟加载。
//因为加载外部类时内部类并不会被加载，只有显式调用getInstance方法才会去进行内部类的加载和instance的初始化
class SingletonInnerclass{
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private SingletonInnerclass (){}
    public static final Singleton getInstance() {
        return SingletonInnerclass.SingletonHolder.INSTANCE;
    }
}

