package OnlineJudge.qita;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

    public static int solve(int n)
    {
        if(n < 3)
            return 0;
        int count = 2;
        int f1 = 1, f2 = 2;
        int temp;
        while(f1 + f2 < n)
        {
            temp = f2;
            f2 = f1 + f2;
            f1 = temp;
            count++;
        }
        return f2-count;
    }
}
