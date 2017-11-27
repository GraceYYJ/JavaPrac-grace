package genericity;

/**
 * Created by Administrator on 2017/7/26.
 */
public class Point <T> {
    private T pointx;
    private T pointy;
    public void setX(T x){
        this.pointx=x;
    }
    public void setY(T y){
        this.pointy=y;
    }
    public T getX(){
        return pointx;
    }
    public T getY(){
        return pointy;
    }
    public static void main(String args[]){
        Point<String> point=new Point<String>();
        point.setX("东经100度");
        point.setY("北纬60度");
        System.out.println(point.getX()+point.getY());
    }
}

