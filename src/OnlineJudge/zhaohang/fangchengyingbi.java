package OnlineJudge.zhaohang;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/22.
 */
public class fangchengyingbi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int querynum=scanner.nextInt();
        int query[][]=new int[querynum][2];
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        for(int i=0;i<querynum;i++){
            query[i][0]=scanner.nextInt();
            query[i][1]=scanner.nextInt();
            String input=scanner.nextLine().trim().replaceAll(" ","");
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<input.length();j++){
                list.add(input.charAt(j)-48);
            }
            lists.add(list);
        }
        for(int i=0;i<querynum;i++){
            System.out.println(getNums(query[i][0],query[i][1],lists.get(i)));
        }
    }
    public static long getNums(int n,int k,ArrayList<Integer> list){
        return 10;
    }
}
