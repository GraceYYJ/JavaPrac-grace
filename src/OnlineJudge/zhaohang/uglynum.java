package OnlineJudge.zhaohang;
import java.util.Scanner;
/**
 * Created by Administrator on 2018/4/10.
 */
public class uglynum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner (System.in);
        int n=scanner.nextInt();
        System.out.println(getnum(n));
    }

    public static int getnum(int index) {
        if(index<=0)    return 0;
        int nums[]=new int[index];
        nums[0]=1;
        int next=1;
        int p2=0;
        int p3=0;
        int p5=0;
        while(next<index) {
            nums[next]=minnum(nums[p2]*2,nums[p3]*3,nums[p5]*5);
            while(nums[p2]*2<=nums[next])
                p2++;
            while(nums[p3]*3<=nums[next])
                p3++;
            while(nums[p5]*5<=nums[next])
                p5++;
            next++;
        }
        int result=nums[next-1];
        return result;
    }
    public static int minnum(int num1,int num2,int num3) {
        int min=Math.min(num1,num2);
        int minmin=Math.min(min,num3);
        return minmin;
    }
}
