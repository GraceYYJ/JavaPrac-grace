package dataStructure.sort;

/**
 * Created by Administrator on 2018/4/4.
 */
public class quicksortv2 {
    public static void main(String[] args) {
        int array[]={3,5,1,2,7,5,6,8};
        quicksort(array,0,7);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void quicksort(int data[],int start,int end){
        if(start==end)
            return;
        int index=partition(data,start,end);
        if(index>start)
            partition(data,start,index-1);
        if(index<end)
            partition(data,index+1,end);
    }
    public static int partition(int data[],int start,int end){
        if(data.length<=0||start<0||end<start){
            return -1;
        }
        int index=start+(end-start)/2;
        swap(data,index,end);
        int small=start-1;
        for(index=start;index<end;index++){
            if(data[index]<data[end]){
                small++;
                if(small!=index)
                    swap(data,small,index);
            }
        }
        small=small+1;
        swap(data,small,end);
        return small;
    }
    public static void swap(int data[],int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
