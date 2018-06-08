package interview.designmode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/7.
 * 自己实现一个观察者模式
 * 一个Subject接口，一个具体Subject，一个Observer接口，多个具体的Observer。
 * 观察者模式又称为发布订阅模式，主要解决一对多的对象间依赖问题，也就是一个对象状态改变给其他对象通知的问题。
 */
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherDataSubject subjectA=new WeatherDataSubject();
        WeatherBoardObserver observerX=new WeatherBoardObserver(subjectA);
        subjectA.change(80,65,30.4f);
    }
}
//Subject接口
interface Subject{
    public void addobserver(Observer observer);
    public void removeobserver(Observer observer);
    public void notifyobserver();
}
//Observer接口
interface Observer{
    public void update(float temp,float humidity,float pressure);
}
//代表天气数据的具体主题——WeatherDataSubject
class WeatherDataSubject implements Subject{
    private float temp;
    private float humidity;
    private float pressure;
    private ArrayList observers;
    public WeatherDataSubject(){
        observers=new ArrayList();
    }
    //实现Subject接口，用一个list来实现观察者的注册、移除和通知
    public void addobserver(Observer o){
        observers.add(o);
    }
    public void removeobserver(Observer o){
        observers.remove(o);
    }
    public void notifyobserver(){
        for(int i=0;i<observers.size();i++){
            Observer observer=(Observer)observers.get(i);
            observer.update(temp,humidity,pressure);
        }
    }
    public void change(float temp,float humidity,float pressure){
        this.temp=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        notifyobserver();
    }
}
//观察天气数据的布告板观察者
class WeatherBoardObserver implements Observer{
    private float temp;
    float humidity;
    float pressure;
    //在构造方法中指定向哪个Subject进行注册：调用该Subject的add方法，参数为this--当前观察者对象。
    private Subject subject;
    public WeatherBoardObserver(Subject subject){
        this.subject=subject;
        subject.addobserver(this);
    }
    //重写Observer接口的update方法
    public void update(float temp,float humidity,float pressure){
        this.temp=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
    public void display(){
        System.out.println(temp);
        System.out.println(humidity);
        System.out.println(pressure);
    }
}

