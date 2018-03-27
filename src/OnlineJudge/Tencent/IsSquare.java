package OnlineJudge.Tencent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Administrator on 2018/3/23.
 */
public class IsSquare {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int array[][]=new int[2*num][4];
        for(int i=0;i<(2*num);i++){
            for(int j=0;j<4;j++){
                array[i][j]=scanner.nextInt();
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        TreeSet<Integer> set=new TreeSet();
        int length=0;
        for(int i=0;i<2*num;i+=2){
            for(int j=0;j<3;j++){
                for(int k=j+1;k<4;k++){
                    double length1=Math.pow(array[i][j]-array[i][k],2)+Math.pow(array[i+1][j]-array[i+1][k],2);
                    length=new Double(length1).intValue();
                    set.add(length);
                }
            }
            if(set.size()==3){
                Iterator iterator=set.iterator();
                while(iterator.hasNext()){
                    result.add((Integer)iterator.next());
                }
                if(result.get(0)+result.get(1)==result.get(2))
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }
    }
}
