package OnlineJudge.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/6.
 */
public class NumberGame {
    public int getBiggestNum(int numbers[],int n){
        if(numbers.length!=n||n<=0)
            return -1;
        for(int i=0;i<numbers.length;i++){
            numbers[i]=changeNum(numbers[i]);
        }
        Arrays.sort(numbers);
        return numbers[numbers.length-1];
    }
    public int changeNum(int number){
        char charnum[]=String.valueOf(number).toCharArray();
        Arrays.sort(charnum);
        String str=String.valueOf(charnum);
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int numbers[]=new int[n];
        for(int i=0;i<n;i++){
            numbers[i]=scanner.nextInt();
        }
        System.out.println(new NumberGame().getBiggestNum(numbers,n));
    }
}
