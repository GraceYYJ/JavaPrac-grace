package jianzhiOffer;

import dataStructure.sort.Partition;

import java.util.Random;

/**
 * Created by Administrator on 2017/12/25.
 */
public class MoreThanHalfNum {
    public int getMoreThanHalfNum(int array[]){
        int length=array.length;
        if(length<=0) return 0;
        int middle=length>>1;
        int start=0;
        int end=length-1;
        //Partition parti=new Partition();
        int index=partition(start,end,array);
        while(index!=middle){
            if(index<middle){
                start=index+1;
                index=partition(start,end,array);
            }
            else{
                end=index-1;
                index=partition(start,end,array);
            }
        }
        int result=array[middle];
        if(check(result,array)) return result;
        else return 0;
    }
    public int partition(int start,int end,int array[]){
        int length=array.length;
        Random random = new Random(length);
        int index=random.nextInt(length);
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
    public boolean check(int result,int array[]){
        boolean isMoreThanHalf=false;
        int length=array.length;
        int halflength=length>>1;
        int count=0;
        for(int i=0;i<length;i++){
            if(array[i]==result)
                count++;
        }
        if(count>halflength)
            isMoreThanHalf=true;
        return isMoreThanHalf;
    }

    public int getMoreThanHalfNum2(int array[]){
        int length=array.length;
        if(length<=0) return 0;
        int result=array[0];
        int times=0;
        for(int i=1;i<length;i++){
            if(times==0){
                result=array[i];
                times=1;
            }
            else if(result==array[i])
                times++;
            else times--;
        }
        if(check(result,array)) return result;
        else return 0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum test=new MoreThanHalfNum();
        int array[]={1,2,3,2,2,2,5,4,2};
        //int array[]={4,4,1,4,2,4,1,4,4,3,4,2,4};
        //int array[]={4,4,1,3,7,9,2,3,4,2,4};
        //int array[]={};
        System.out.println(test.getMoreThanHalfNum2(array));
    }
}
