package DP;

/**
 * Created by Administrator on 2018/5/4.
 * 从数组中选出不相邻的几个数，使和最大，输出和
 * 从后往前，每个数都可以选或不选，可以形成递归树。
 */
public class DP1 {
    //递归方法
    public static int sum_rec(int array[],int i){
        int A,B;
        if(i==0)
            return array[0];
        else if(i==1)
            return Math.max(array[0],array[1]);
        else
            A=sum_rec(array,i-2)+array[i];
            B=sum_rec(array,i-1);
            return Math.max(A,B);
    }
    //非递归方法，从小到大，用数组保存结果
    public static int sum_norec(int array[]){
        int result[]=new int[array.length];
        result[0]=array[0];
        result[1]=Math.max(array[1],array[0]);
        for(int i=2;i<result.length;i++){
            int A=result[i-2]+array[i];
            int B=result[i-1];
            result[i]=Math.max(A,B);
        }
        return result[result.length-1];
    }

    public static void main(String[] args) {
        int array[]={1,4,9,1,1};
        System.out.println(sum_rec(array,array.length-1));
        System.out.println(sum_norec(array));
    }
}
