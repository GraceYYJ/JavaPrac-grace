package interview.designmode;

/**
 * Created by Administrator on 2018/4/11.
 */
public class FactoryMode {
    public static void main(String[] args) {
        //测试简单工厂,改善了紧耦合，通过传参就能拿到想要的对象
        Shape shape = new ShapeFactory().getShape("CIRCLE");
        shape.draw();
       //测试工厂方法，不需要传参，直接调用对应的工厂就可以
        CarFactory cf=new BAOMAFactory();
        cf.getCar().run();
        //测试抽象工厂
        new baomafactory().createwindow();
        new benchifactory().createseat();
    }
}
/***************简单工厂***************/
interface Shape{
    public void draw();
}
class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("produce a Rectangle");
    }
}
class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("produce a Circle");
    }
}
class Triangle implements Shape{
    @Override
    public void draw(){
        System.out.println("produce a Triangle");
    }
}
//用于创建的工厂,根据传入的参数来决定创建的对象类型
class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Triangle();
        }
        return null;
    }
}
/***************工厂方法********************
 * 由于简单工厂每增加一个形状，都要修改工厂的生产代码
 * 所以工厂方法采用多工厂的思想，每个产品对应一个工厂，新增产品就新增工厂***************/
interface Car{
    public void run();
}
class BAOMA implements Car{
    @Override
    public void run(){
        System.out.println("I AM BAOMA");
    }
}
class BENCHI implements Car{
    @Override
    public void run(){
        System.out.println("I AM BENCHI");
    }
}
//工厂也用接口，多个不同类的工厂都实现这个接口
interface CarFactory{
    public Car getCar();
}
class BAOMAFactory implements CarFactory{
    @Override
    public Car getCar(){
        return new BAOMA();
    }
}
class BENCHIFactory implements CarFactory{
    @Override
    public Car getCar(){
        return new BENCHI();
    }
}
/***************抽象工厂********************
 * 工厂方法每个产品对应一个工厂，而我们想要的是一类产品对应一个工厂，从而解决产品簇的问题***************/
interface window{
    public void producewindow();
}
class baomawindow implements window{
    @Override
    public void producewindow(){
        System.out.println("BAOMA's window");
    }
}
class benchiwindow implements window{
    @Override
    public void producewindow(){
        System.out.println("BENCHI's window");
    }
}
interface seat{
    public void produceseat();
}
class baomaseat implements seat{
    @Override
    public void produceseat(){
        System.out.println("BAOMA's seat");
    }
}
class benchiseat implements seat{
    @Override
    public void produceseat(){
        System.out.println("BENCHI's seat");
    }
}
interface goodCarFactory{
    public window createwindow();
    public seat createseat();
}
class baomafactory implements goodCarFactory{
    @Override
    public window createwindow(){
        return new baomawindow();
    }
    @Override
    public seat createseat(){
        return new baomaseat();
    }
}
class benchifactory implements goodCarFactory{
    @Override
    public window createwindow(){
        return new benchiwindow();
    }
    @Override
    public seat createseat(){
        return new benchiseat();
    }
}



