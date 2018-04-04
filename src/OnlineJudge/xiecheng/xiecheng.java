package OnlineJudge.xiecheng;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/29.
 */
public class xiecheng {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        if(length<0)
            return;
        int array[]=new int[length];
        for(int i=0;i<length;i++){
            array[i]=scanner.nextInt();
        }
        int j=0;
        for(int i=0;i<length;i++){
            if(array[i]!=0){
                array[j]=array[i];
                j++;
            }
/*            if(array[i]==0){
                int temp=array[i];
                for(int j=i+1;j<length;j++){
                    array[j-1]=array[j];
                }
                array[length-1]=0;
            }*/
        }
        for(j=j;j<array.length;j++){
            array[j]=0;
        }
        for(int i=0;i<length;i++)
            System.out.println(array[i]);
    }
}
