package OnlineJudge;

import java.util.IdentityHashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/18.
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 */
public class RotateNumcompare {
    public int repeat(int x,int k){
        if(x<=0||k<=0)
            return -1;
        int digit=String.valueOf(x).length();
        int newx=0;
        for(int i=1;i<=k;i++){
            newx+=Math.pow(10.0,digit*(k-i));
        }
        newx*=x;
        return newx;
    }
    public void RotNumcompare(){
        Scanner sc=new Scanner(System.in);
        sc.useDelimiter("\n");
        String input[]=sc.nextLine().toString().split(" ");
        int x1=Integer.parseInt(input[0]);
        int k1=Integer.parseInt(input[1]);
        int x2=Integer.parseInt(input[2]);
        int k2=Integer.parseInt(input[3]);
        System.out.println(compare(repeat2(x1,k1),repeat2(x2,k2)));
    }
    public String repeat2(int x,int k){
        String strx=String.valueOf(x);
        StringBuffer strx2=new StringBuffer(strx);
        while(k>1){
            k--;
            strx2.append(strx);
        }
        return strx2.toString();
    }
    public String compare(String x1,String x2){
        int flag=0;
        if(x1.length()>x2.length())
            return "Greater";
        else if(x1.length()<x2.length())
            return "Less";
        else {
            assert (x1.length()==x2.length());
            int length=x1.length();
            for(int i=0;i<length;i++){
                //int newx1=(int)x1.charAt(i)-48;
                //int newx2=(int)x2.charAt(i)-48;
                if(x1.charAt(i)>x2.charAt(i))
                    return "Greater";
                if(x1.charAt(i)<x2.charAt(i))
                    return "Less";
            }
            return "Eaqul";
        }
    }
    public static void main(String[] args) {
        RotateNumcompare test=new RotateNumcompare();
        test.RotNumcompare();
    }
}
