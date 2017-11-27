package leetcode;

/**
 * Created by GraceYang on 2017/8/24.
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int q=Integer.parseInt(a.substring(0,a.indexOf("+")));
        int w=Integer.parseInt(a.substring(a.indexOf("+")+1,a.indexOf("i")));
        int e=Integer.parseInt(b.substring(0,b.indexOf("+")));
        int r=Integer.parseInt(b.substring(b.indexOf("+")+1,b.indexOf("i")));
        int x=q*e-w*r;
        int y=w*e+q*r;
        System.out.println(x);
        System.out.println(y);
        return String.valueOf(x)+"+"+String.valueOf(y)+"i";
    }
    public static void main(String args[]){
        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply("2+-2i","1+1i"));
    }
}
