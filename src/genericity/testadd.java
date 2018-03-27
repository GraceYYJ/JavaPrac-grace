package genericity;

/**
 * Created by GraceYang on 2018/2/27.
 */
public class testadd {
    static{
        int x=5;
    }
    static int x,y;
    public static void main(String[] args) {
//        int i=0;
//        boolean b=true?false:false?false:true;
//        System.out.println(b);
/*        double d1=-0.5;
        System.out.println("Ceil d1="+Math.ceil(d1));
        System.out.println("floor d1="+Math.floor(d1));*/

/*                x--;
                myMethod( );
                System.out.println(x+y+ ++x);
        }
    public static void myMethod( ){
        y=x++ + ++x;
    }*/
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.print(n1 == n2);
        System.out.print(",");
        System.out.println(n1 != n2);
    }
}
