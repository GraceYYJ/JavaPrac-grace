package genericity;

/**
 * Created by GraceYang on 2018/2/28.
 */
public class foo {
    public static void main(String sgf[]) {

        StringBuffer a=new StringBuffer("A");

        StringBuffer b=new StringBuffer("B");

        operate(a,b);

        System.out.println(a+"."+b);
        String C="ABC";
        C="CDE";
        System.out.println(C);

    }
    static void operate(StringBuffer x,StringBuffer y) {
        x.append(y);
        y=x;
    }
}