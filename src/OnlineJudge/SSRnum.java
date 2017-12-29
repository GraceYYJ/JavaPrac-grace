package OnlineJudge;

import javafx.util.Pair;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/19.
 */
public class SSRnum {
    //复杂度过大，考虑其他做法
    public int SSRnumber(int n,int m){
        int number=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                double sqrt=Math.sqrt((double)(i*j));
                String result=Double.toString(sqrt);
                int resultlength=result.length();
                int point=result.indexOf('.')+1;
                boolean isInterger=true;
                while(point<resultlength){
                    if(result.charAt(point)!='0')
                        isInterger=false;
                    point++;
                }
                if(isInterger)
                    number++;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input[]=scanner.nextLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);
        SSRnum test=new SSRnum();
        System.out.println(test.SSRnumber(n,m));
    }
}
