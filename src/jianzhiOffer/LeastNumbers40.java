package jianzhiOffer;

import dataStructure.sort.Partition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Administrator on 2017/12/26.
 */
public class LeastNumbers40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int length=input.length;
        ArrayList<Integer> LeastList=new ArrayList<Integer>();
        if(length<=0||length<k||k<=0) return LeastList;
        int start=0;
        int end=length-1;
        int index=partition(start,end,input);
        while(index!=k-1){
            if(index<k-1){
                start=index+1;
                index=partition(start,end,input);
            }
            else {
                end=index-1;
                index=partition(start,end,input);
            }
        }
        for(int i=0;i<k;i++){
            LeastList.add(input[i]);
        }
        return LeastList;
    }


    public int partition(int start,int end,int array[]){
        int length=array.length;
        int index=new Random().nextInt(end-start+1)+start;
        int small=start-1;
        swap(index,end,array);
        for(index=start;index<end;index++){
            if(array[index]<array[end]){
                small++;
                if(small!=index)
                    swap(small,index,array);
            }
        }
        small++;
        swap(small,end,array);
        return small;
    }

    public void swap(int i,int j,int array[]){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static void main(String[] args) {
        LeastNumbers40 test=new LeastNumbers40();
        int input[]={4,5,1,6,2,7,3,8};
        ArrayList<Integer> LeastList=test.GetLeastNumbers_Solution(input,1);
        Iterator<Integer> iterator=LeastList.iterator();
        while(iterator.hasNext()){
            //Integer x=iterator.next();
            System.out.println(iterator.next());
        }
    }
}
