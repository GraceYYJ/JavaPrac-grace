package OnlineJudge.jingdong;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/9.
 */
public class huiwenchuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        int n=str.length();
        long dp[][]=new long[n+1][n+1];
        for(int i=0;i<n;++i)
            dp[i][i]=1;
        for (int k=2;k<=n;++k){
            for (int i=0;i<n;++i) {
                int t=k+i-1;
                if(t<n){
                    if(str.charAt(i)==str.charAt(t))
                        dp[i][t]=dp[i][t-1]+dp[i+1][t]+1;
                    else
                        dp[i][t]=dp[i][t-1]+dp[i+1][t]-dp[i+1][t-1];
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
