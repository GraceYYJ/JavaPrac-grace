package dataStructure.sort;

import java.util.Random;

/**
 * Created by Administrator on 2017/12/25.
 */
public class Partition {
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
}
