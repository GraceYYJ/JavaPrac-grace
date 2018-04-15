package dataStructure.find;

/**
 * Created by Administrator on 2018/4/4.
 */
public class binarysearch {
    public static int binsearchrecur(int array[],int start,int end, int target){
        if(start>end) return -1;
        int k=start+(end-start)/2;
        if(array[k]==target)
            return k;
        if(array[k]>target)
            return binsearchrecur(array,start,k-1,target);
        else
           return binsearchrecur(array,k+1,end,target);
    }
    public static int binsearch(int array[],int target){
        int n=array.length;
        if(n<=0) return -1;
        int index=n/2;
        int start=0,end=n-1;
        while(start<end&&array[index]!=target){
            if(array[index]>target){
                end=index-1;
                index=start+(end-start)/2;
            }
            else {
                start=index+1;
                index=start+(end-start)/2;
            }
        }
        if(array[index]!=target) return -1;
        return index;
    }
    public static int searchmaxclosed(int array[],double target){
        int n=array.length;
        if(n<=0) return -1;
        int index=n/2;
        int start=0,end=n-1;
        int maxclosednum=array[index];
        while(start<end){
            if(array[index]>target){
                maxclosednum=maxclosednum<array[index]-target?maxclosednum:array[index];
                end=index-1;
                index=start+(end-start)/2;
            }
            else {
                start=index+1;
                index=start+(end-start)/2;
            }
        }
        return maxclosednum;
    }
    public static int searchfirstappear(int array[],int target){
        int n=array.length;
        if(n<=0) return -1;
        int index=n/2;
        int start=0,end=n-1;
        while(start<end&&array[index]!=target){
            if(array[index]>target){
                end=index-1;
                index=start+(end-start)/2;
            }
            else {
                start=index+1;
                index=start+(end-start)/2;
            }
        }
        if(array[index]!=target) return -1;
        while(index>=0&&array[index]==target){
            index--;
        }
        return index+1;
    }
    public static void main(String[] args) {
        int array[]={1,2,3,4,5};
        int array2[]={1,2,3,3,4,5,5,5,7};
        System.out.println(binsearchrecur(array,0,4,2));
        System.out.println(binsearch(array,2));
        System.out.println(searchmaxclosed(array,3.5));
        System.out.println(searchfirstappear(array2,5));
    }
}
