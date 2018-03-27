package OnlineJudge.niuke0314;

/**
 * Created by Administrator on 2018/3/15.
 */
import java.util.*;
public class Coin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int[] coins = new int[n];
        for (int i=0;i<n;++i){
            coins[i] = in.nextInt();
        }
        Arrays.sort(coins);
        int sum = 0;
        int ans = 0;
        int k = 0;
        while ((sum <= s)&&(k<s)){
            sum += coins[k];
            ans++;
            k++;
        }
        int minx = 9999;
        while (sum - coins[0] >= s){
            for (int i=k-1;i>=0;--i){
                if (sum - coins[i] >= s){
                    sum -= coins[i];
                    ans--;
                    k = i;
                    break;
                }
            }
        }
        System.out.println(ans);
        return;
    }
}

