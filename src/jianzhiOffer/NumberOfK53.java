package jianzhiOffer;

/**
 * Created by Administrator on 2018/1/9.
 */
public class NumberOfK53 {
    public int getNumberOfK(int array[],int k){
        if(array.length<=0) return 0;
        int number=0;
        int firstkIndex=getFirstK(array,k,0,array.length-1);
        int lastkIndex=getLastK(array,k,0,array.length-1);
        if(firstkIndex>-1&&lastkIndex>-1) number=lastkIndex-firstkIndex+1;
        return number;
    }
    //采取二分法找第一个k的索引值，递归。
    public int getFirstK(int array[],int k,int start,int end){
        if(start>end) return -1;
        int middleindex=(start+end)/2;
        int middledata=array[middleindex];
        //如果中间值为k，中间值可能是第一个k
        if(middledata==k){
            if(middleindex==0||(array[middleindex-1]!=k&&middleindex>0))
                return middleindex;
            else
                end=middleindex-1;
        }
        //如果中间值不为k，改变start/end继续二分查找
        else {
            if(middledata>k)
                end=middleindex-1;
            else
                start=middleindex+1;
        }
        //递归调用
        return getFirstK(array,k,start,end);
    }
    //采取二分法找第数组最后一个k的索引值，递归。
    public int getLastK(int array[],int k,int start,int end){
        if(start>end) return -1;
        int middleindex=(start+end)/2;
        int middledata=array[middleindex];
        //如果中间值为k，中间值可能是最后一个k
        if(middledata==k){
            if(middleindex==array.length-1||(array[middleindex+1]!=k&&middleindex<array.length-1))
                return middleindex;
            else
                start=middleindex+1;
        }
        //如果中间值不为k，改变start/end继续二分查找
        else {
            if(middledata>k)
                end=middleindex-1;
            else
                start=middleindex+1;
        }
        //递归调用
        return getLastK(array,k,start,end);
    }

    //找寻0~n-1中缺失的数字：第一个下标和数字值不同的元素-1便是。
    public int getMissingNumber(int array[]){
        int length=array.length;
        if(length<=0||length<array[length-1]) return -1;
        int left=0;
        int right=length-1;
        while(left<=right) {
            int middle = (right + left) >> 1;
            if (array[middle] != middle) {
                if (middle == 0 || array[middle - 1] == middle - 1)
                    return middle;
                right = middle - 1;
            } else
                left = middle + 1;
        }
        return -1;
    }
    public int getMissingNumber2(int array[]){
        int length=array.length;
        if(length<=0||length<array[length-1]) return -1;
        int left=0;
        int right=length-1;
        return findMissingNum(array,left,right);
    }
    public int findMissingNum(int array[],int left,int right){
        if(left==right) return array[left]-1;
        if(left>right) return -1;
        int middle = (right + left) >> 1;
        if (array[middle] != middle) {
            if (middle == 0 || array[middle - 1] == middle - 1)
                return middle;
            right = middle - 1;
        } else
            left = middle + 1;
        return findMissingNum(array,left,right);
    }
    public static void main(String[] args) {
        int array1[]={};
        int array2[]={0,1,3,4,5,6,7};
        System.out.println(new NumberOfK53().getNumberOfK(array1,2));
        System.out.println(new NumberOfK53().getNumberOfK(array2,0));
        System.out.println(new NumberOfK53().getMissingNumber2(array2));
    }
}
