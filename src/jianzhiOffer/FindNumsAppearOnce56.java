package jianzhiOffer;

/**
 * Created by Administrator on 2018/2/1.
 */
public class FindNumsAppearOnce56 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //从头至尾依次异或得到xorResult
        int xorResult=array[0];
        for(int i=1;i<array.length;i++){
            xorResult=xorResult^array[i];
        }
//        System.out.println(xorResult);
        //找xorResult第一个1的位数
        int count=0;
        int xorResulttmp=xorResult;
        while(xorResulttmp!=0){
            xorResulttmp=xorResulttmp>>1;
            count++;
        }
//        System.out.println(count);
        xorResulttmp=(int)Math.pow(2,count-1);
        int j=0,k=0;
        for(int i=0;i<array.length;i++){
            if((array[i]&xorResulttmp)!=0){
                num1[0]=num1[0]^array[i];
                j++;
            }
            else {
                num2[0]=num2[0]^array[i];
                k++;
            }
        }
//        for(int i=1;i<num1.length;i++){
//            num1[0]=num1[0]^num1[i];
//        }
//        for(int i=1;i<num2.length;i++){
//            num2[0]=num2[0]^num2[i];
//        }
        System.out.print(num1[0]+" ");
        System.out.print(num2[0]+" ");
    }

    public static void main(String[] args) {
        FindNumsAppearOnce56 test=new FindNumsAppearOnce56();
        int array[]={2,4,3,6,3,2,5,5};
        int num1[]=new int[array.length];
        int num2[]=new int[array.length];;
        test.FindNumsAppearOnce(array,num1,num2);
    }
}
