package OnlineJudge.niuke0314;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/14.
 */
public class yingbi {
    void sort(int A[]) {
        int i, j, temp;
        int n = A.length;
        for (i = 1; i < n; i++) {
            temp = A[i];
            if (A[i] < A[i - 1]) {
                for (j = i - 1; j >= 0 && temp < A[j]; j--) {
                    A[j + 1] = A[j];
                }
                A[j + 1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
/*        if(n<=0||sum<=0){
            System.out.println(0);
            return;
        }*/
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        yingbi test = new yingbi();
        test.sort(p);
        int result = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            result += p[i];
            if (result == sum) {
                System.out.println(i + 1);
                return;
            }
            if (result > sum) {
                flag = i + 1;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (result - p[i] >= sum) {
                result -= p[i];
                flag--;
            }
        }
        System.out.println(flag);
    }
}
