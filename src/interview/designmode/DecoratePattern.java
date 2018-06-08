package interview.designmode;

import java.io.*;

/**
 * Created by Administrator on 2018/5/22.
 */
public class DecoratePattern {
    public static void main(String[] args) throws FileNotFoundException {
        //来一个大杯的好咖啡，加奶泡（20+5=25元）
        Drink drink1=new GoodCoffee("grande");
        drink1=new milkfoam(drink1);
        System.out.println(drink1.getDescription()+". price: "+drink1.cost());
        //来一个小杯的差咖啡，加2份冰淇淋（10+2*8=26元）
        Drink drink2=new BadCoffee("small");
        drink2=new icecream(drink2);
        drink2=new icecream(drink2);
        System.out.println(drink2.getDescription()+". price: "+drink2.cost());
        File file=new File("E:\\a.text");
        FileInputStream fin=new FileInputStream(file);
        BufferedInputStream bin=new BufferedInputStream(fin);

    }
}
//被装饰者的基类
abstract class Drink{
    String Description="unknown drink";
    String getDescription(){
        return Description;
    }
    abstract double cost();
}
//装饰者的基类，需要继承被装饰者基类，以保持装饰后类型的一致
abstract class CondimentDecorate extends Drink{
    abstract String getDescription();
}
//具体被装饰的类GoodCoffee
class GoodCoffee extends Drink{
    String size;
    GoodCoffee(String size){
        this.size=size;
        Description=size+" GoodCoffee";
    }
    //goodcoffee小杯15元，大杯20元
    double cost(){
        if(size=="small")
            return 15;
        if(size=="grande")
            return 20;
        else return 0;
    }
}
//具体被装饰的类BadCoffee
class BadCoffee extends Drink{
    String size;
    BadCoffee(String size){
        this.size=size;
        Description=size+" BadCoffee";
    }
    double cost(){
        //BadCoffee小杯10元，大杯15元
        if(size=="small")
            return 10;
        if(size=="grande")
            return 15;
        else return 0;
    }
}

//具体装饰类milkfoam
class milkfoam extends CondimentDecorate{
    Drink drink;
    milkfoam(Drink drink){
        this.drink=drink;
    }
    String getDescription(){
        return drink.getDescription()+",add milkfoam";
    }
    double cost(){
        //根据传入的具体drink确定饮品的基本价格
        return drink.cost()+5;
    }
}
//具体装饰类icecream
class icecream extends CondimentDecorate{
    Drink drink;
    icecream(Drink drink){
        this.drink=drink;
    }
    String getDescription(){
        return drink.getDescription()+",add icecream";
    }
    double cost(){
        //根据传入的具体drink确定饮品的基本价格
        return drink.cost()+8;
    }
}