package OnlineJudge.jingdong;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/9.
 */
public class fenjie {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long array[]=new long[n];
        for(int i=0;i<n;i++){
            array[i]=scanner.nextLong();
        }
        for(int i=0;i<n;i++){
            if(array[i]%2!=0)
                System.out.println("No");
            else {
                for(int y=2;y<array[i];y+=2){
                    long mod=array[i]%y;
                    long x=array[i]/y;
                    if(mod!=0)
                        continue;
                    if(mod==0&&x%2!=0){
                        System.out.println(x+" "+y);
                        break;
                    }
                }
            }
        }
    }
}
