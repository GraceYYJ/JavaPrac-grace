package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GraceYang on 2018/3/2.
 */
public class Multiply66 {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
/*        int A[]={1,2,3,4,5};
        int B[]=new Multiply66().multiply(A);
        for(int i=0;i<B.length;i++){
            System.out.print(B[i]+" ");
        }
        int []c[]=new int[6][7];*/
        List<Integer> NumberList =new ArrayList<Integer>();
        NumberList.add(2);
        NumberList.add(4);
        NumberList.add(1);
        NumberList.add(3);
        NumberList.add(5);
        for(int i =0;i<NumberList.size();++i)
        {
            int v = NumberList.get(i);
            if(v%2==0)
            {
                NumberList.remove(i);
            }
        }
        System.out.println(NumberList);

    }
}
