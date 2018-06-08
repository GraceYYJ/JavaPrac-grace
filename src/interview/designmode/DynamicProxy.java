package interview.designmode;

public class DynamicProxy {
}
interface IPerson{
    public String introduce(String name);
    public String haveLunch(String food);
}
class RealPerson implements IPerson{
    public String introduce(String name){
        return "I AM"+name;
    }
    public String haveLunch(String food){
        return "I EAT"+food;
    }
}
