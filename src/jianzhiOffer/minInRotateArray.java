package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/7.
 */
public class minInRotateArray {
    public int minNumberInRotateArray(int array[]){
        int p=0;
        int q=array.length-1;
        int mid=0;
        if(array.length<=0)
            return 0;
        if(array[p]<array[q]){
            return array[p];
        }
        while(q>p+1){
            mid=(p+q)/2;
            if(array[mid]==array[p]&&array[p]==array[q]){
                int result=array[p];
                for(int i=p+1;i<q;i++){
                    if(array[i]<result)
                        result=array[i];
                }
                return result;
            }
            if(array[mid]>array[q])
                p=mid;
            else
                q=mid;
        }
        return array[p]<array[q]?array[p]:array[q];
    }

    public static void main(String[] args) {
        int array[]={3,4,5,6,1,2,3,3,3};
        minInRotateArray test=new minInRotateArray();
        System.out.println(test.minNumberInRotateArray(array));
    }
}
