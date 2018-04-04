package OnlineJudge.wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/27.
 */
public class rectangle{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int recnum=scanner.nextInt();
        int point[][]=new int[4][recnum];
        for(int i=0;i<4;i++){
            for(int j=0;j<recnum;j++){
                point[i][j]=scanner.nextInt();
            }
        }
        int count=1;
        int maxcount=0;
        for(int i=0;i<recnum;i++){
            for(int j=0;j<recnum;j++){
                if(i!=j&&point[0][i]>point[0][j]&&point[0][i]<point[2][j]
                        &&point[1][i]>point[1][j]&&point[1][i]<point[3][j])
                    count++;
            }
        }
        System.out.println(count);
    }
}
