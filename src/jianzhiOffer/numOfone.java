package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/16.
 */
public class numOfone {
    //只考虑正数的简单方法
    public int numofone1(int n){
        int count=0;
        //String binaryString=Integer.toBinaryString(n);
        while(n!=0){
            if((n&1)==1) count++;
            n=n>>1;
        }
        return count;
    }
    //应对负数的解法，左移flag，复杂度为o(n)
    public int numofone2(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0)
                count++;
            flag=flag<<1;
        }
        return count;
    }
    //复杂度为o(1的个数)的解法，将n-1和n做与运算，可使最右边的1变为0，持续操作，直至n为0
    public int numofone3(int n){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        numOfone test=new numOfone();
        System.out.println(test.numofone3(9));
    }
}
