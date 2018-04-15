package leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/11.
 */
public class TwoSum1 {
    public static void main(String args[]){
        TwoSum1 test=new TwoSum1();
        int nums[]={2,1,6,4,4};
        int result[]=test.twoSum(nums,8);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] index=new int[]{0,1};
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length; i++) {
            if(hm.containsKey(target - nums[i])) {
                index[1] = i;
                index[0] = hm.get(target-nums[i]);
                return index;
            }else {
                hm.put(nums[i],i);
            }
        }
        return index;
    }
}
