package OnlineJudge.xiecheng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/29.
 */
public class rotatematrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line1=scanner.nextLine().trim();
        int n=line1.split(" ").length;
        int matrix[][]=new int[n][n];
        String line2=line1.replaceAll(" ","");
        for(int i=0;i<n;i++){
            matrix[0][i]=line2.charAt(i)-48;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }

        int k=(n-1)/2;
        int temp=0;
        for(int i=0;i<=k;i++){
            for(int j=i;j<n-i-1;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]);
                if(j<n-1)
                    System.out.print(" ");
                else
                    System.out.println();
            }
        }
    }
}
