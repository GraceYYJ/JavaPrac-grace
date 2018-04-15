package OnlineJudge.Tencent;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/5.
 */
public class reversearray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long n=scanner.nextLong();
        long m=scanner.nextLong();
        if(n%m!=0)
            return;
        long result=n*m/2;
        System.out.println(result);
    }
}
