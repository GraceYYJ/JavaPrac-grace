package leetcode;

import java.util.Arrays;

/**
 * Created by GraceYang on 2017/8/24.
 */
public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        int result=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i+=2){
            result=result+nums[i];
        }
        return result;
    }
    public static void main(String args[]){
        int[] nums={1,4,3,2,6,7};
        System.out.println(new ArrayPartition1().arrayPairSum(nums));
    }
}
