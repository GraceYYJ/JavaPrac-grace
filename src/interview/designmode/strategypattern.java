package interview.designmode;

/**
 * Created by Administrator on 2018/5/5.
 * 策略模式：定义一系列的算法（算法族），将它们都封装起来，使它们之间可以相互替换。
 * 应用场景：比如对不同的类对象要采用不同的算法，对不同级别的的用户的商品折扣不同。
 */
/**
 * 测试策略模式
 */
public class strategypattern {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
/**
 * 策略接口和算法族
 */
interface Strategy {
    public int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubstract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
/**
 * 执行策略的类,类中有一个和接口方法差不多的方法，在这里面设定用什么策略
 */
class Context{
    public Strategy strategy;
    Context(Strategy strategy){
        this.strategy=strategy;
    }
    int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}

