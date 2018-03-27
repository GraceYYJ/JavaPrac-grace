package OnlineJudge.niuke0314;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/14.
 */
public class xianglian {
    public static void main(String[] args) {
/*        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int array[][]=new int[n][2];
        for(int i=0;i<n;i++){
            array[i][0]=scanner.nextInt();
            array[i][1]=scanner.nextInt();
        }*/
        int result=0;
        for(int i=0;i<=3;i++){
            for(int j=0;j<=3;j++){
                for(int k=0;k<=3;k++){
                    if(i+j+k==5)
                        result++;
                }
            }
        }
        System.out.println(result);
    }
}
