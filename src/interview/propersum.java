package interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/2.
 */
public class propersum {
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
    public static boolean hasproper(int array[],int sum){
        int n=array.length;
        //n=5,5个数字，就有2的5次方-1种选取方式
        //用二进制表示，1表示被选，那么有00001,00010,00100,01000,10000,00011,00101.....11111
        //1<<n表示1*2的n次方
        int k=1<<n;
        for(int i=1;i<k;i++){
            int result=0;
            for(int j=0;j<n;j++){
                //t有n种可能，对应j从0-n-1，t的值从2的0次方到2的n-1次方，代表第1-n位是0
                //如00001,00010,00100,01000,10000
                int t=1<<j;
                //i是外层循环，固定住了，选的那几位为1，就把那几位累加起来
                if ((i & t) != 0) {
                    result += array[i];
                }
                //如果result==sum
                if (result == sum) {
                    return true;
                }
            }
        }
        return false;
    }
}
