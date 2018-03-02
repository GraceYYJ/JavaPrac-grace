package jianzhiOffer;

import java.util.ArrayList;

/**
 * Created by GraceYang on 2018/2/7.
 */
public class NumberswithSum57 {
     public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i=0;
        int j=array.length-1;
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(array.length<=0)
            return list;
        int result=0;
        while(i!=j){
            result=array[i]+array[j];
            if(result==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }
            if(result>sum)
                j--;
            if(result<sum)
                i++;
        }
        return list;
    }

    public static void main(String[] args) {
        int array[]={1,2,4,7,11,15};
        ArrayList<Integer> list=new ArrayList<Integer>();
        list=new NumberswithSum57().FindNumbersWithSum(array,15);
        System.out.println(list);
    }
}

