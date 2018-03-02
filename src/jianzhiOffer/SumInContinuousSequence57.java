package jianzhiOffer;

import java.util.ArrayList;

/**
 * Created by GraceYang on 2018/2/7.
 */
public class SumInContinuousSequence57 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int a=1;
        int b=2;
        int result=0;
        ArrayList<ArrayList<Integer>>lists=new ArrayList<>();
        if(sum<=0)
            return lists;
        while(a<=(sum+1)/2){
            result=(a+b)*(b-a+1)/2;
            if(result==sum){
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=a;i<=b;i++){
                    list.add(i);
                }
                lists.add(list);
                a++;
            }
            if(result<sum)
                b++;
            if(result>sum)
                a++;
        }
        return lists;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>lists=new SumInContinuousSequence57().FindContinuousSequence(15);
        System.out.println(lists);
    }
}
