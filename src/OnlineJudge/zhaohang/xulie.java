package OnlineJudge.zhaohang;

/**
 * Created by Administrator on 2018/4/10.
 */
import java.util.Scanner;

public class xulie {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int s=0;
        for(int i = 0; i < n; i++)
            s+=scanner.nextInt();
        int result=n*(n+1)/2-s;
        System.out.println(result);
    }
}
