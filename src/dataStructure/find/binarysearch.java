package dataStructure.find;

/**
 * Created by Administrator on 2018/4/4.
 */
public class binarysearch {
    public static int binsearch(int array[],int start,int end, int target){
        if(start>end)
            return -1;
        int k=start+(end-start)/2;
        if(array[k]==target)
            return k;
        if(array[k]>target)
            return binsearch(array,start,k-1,target);
        else
           return binsearch(array,k+1,end,target);
    }
    public static int binsearch2(int array[],int target){
        int n=array.length;
        return -1;
    }

    public static void main(String[] args) {
        int array[]={1,2,3,4,5};
        System.out.println(binsearch(array,0,4,2));
    }
}
