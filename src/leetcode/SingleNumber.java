package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/9/7.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while((nums.length>i+1)&&(nums[i]==nums[i+1])){
            i+=2;
        }
        return nums[i];
    }

    public static void main(String[] args) {
        //int nums[]={3,2,3,1,2,4,1,5,6,6,5};
        int nums[]={3,2,3,1,2,1,4};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
