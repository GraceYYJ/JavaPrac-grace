package OnlineJudge.wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/27.
 */
public class numtest {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i%j>=k)
                  count++;
            }
        }
        System.out.println(count);
    }
}
