package jianzhiOffer;

/**
 * Created by Administrator on 2017/12/26.
 */
public class GreatestSumOfSubArray42 {
    public int getGreatestSumOfSubArray(int array[]){
        if(array.length<=0)
            return 0;
        int Sum=array[0];
        int Result=array[0];
        for(int i=1;i<array.length;i++){
            if(Sum<0) Sum=array[i];
            else Sum=Sum+array[i];
            if(Sum>Result)
                Result=Sum;
        }
        return Result;
    }

    public static void main(String[] args) {
        GreatestSumOfSubArray42 test=new GreatestSumOfSubArray42();
        int array[]={2,8,1,5,9};
        System.out.println(test.getGreatestSumOfSubArray(array));
    }
}
