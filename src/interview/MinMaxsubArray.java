package interview;

/**
 * Created by Administrator on 2018/4/4.
 * https://blog.csdn.net/JayMining/article/details/78703983
 */
public class MinMaxsubArray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum =-2147483647;
        int sstart=0;
        int send=0;
        int minstart=0;
        for(int i=0;i<n;i++){
            send+=nums[i];
            if(sstart<minstart)
                minstart=sstart;
            if(send-minstart>sum)
                sum=send-minstart;
            sstart+=nums[i];
        }
        return sum;
    }
    public static int minSubArray(int[] nums) {
        int n = nums.length;
        int sum =2147483647;
        int sstart=0;
        int send=0;
        int maxstart=0;
        for(int i=0;i<n;i++){
            send+=nums[i];
            if(sstart>maxstart)
                maxstart=sstart;
            if(send-maxstart<sum)
                sum=send-maxstart;
            sstart+=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int array[]={-1,2,-3,-3,7,1};
        System.out.println(minSubArray(array));
    }
}
