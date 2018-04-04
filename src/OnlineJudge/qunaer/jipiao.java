package OnlineJudge.qunaer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/2.
 */
public class jipiao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int length = list.size();
        int k=1<<length;
        for (int i = 1; i < k; i++) {
            int result = 0;
            for (int j = 0; j < length; j++) {
                int t=1<<j;
                if ((i & t) != 0) {
                    result += list.get(j);
                }
            }
            if (result == m) {
                System.out.println("perfect");
                return;
            }
        }
        System.out.println("good");
    }
}
