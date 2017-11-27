package genericity;
/**
 * Created by Administrator on 2017/7/26.
 */
interface IColor{
    public String getColor();
}
enum Color implements IColor{
    RED("红色"),GREEN("绿色"),BLUE("蓝色") ;
    private String title;
    private Color(String title){
        this.title=title;
    }
    public String toString(){
        return this.title;
    }
    @Override
    public String getColor() {
        return this.title;
    }
}
public class TestDemo {
    public static void main(String args[]){
        IColor color=Color.BLUE;
        for(Color temp:Color.values()){
            System.out.println(color);
        }
    }
}

