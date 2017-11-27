package jianzhiOffer;

/**
 * Created by Administrator on 2017/10/25.
 */
public class fibonacci10 {
    public int fibanacciv1(int n){
        int result[]={0,1};
        if(n<2) return result[n];
        int fibnminus2=0;
        int fibnminus1=1;
        int fibn=0;
        for(int i=2;i<=n;i++){
            fibn=fibnminus1+fibnminus2;
            fibnminus2=fibnminus1;
            fibnminus1=fibn;
        }
        return fibn;
    }


   /* public int[][] matrixmulti(int a[][],b[][]){
        array[0][0]=array[0][0]*array[0][0]+array[0][1]*array[1][0];
        array[0][1]=array[0][0]*array[0][1]+array[0][1]*array[1][1];
        array[1][0]=array[1][0]*array[0][0]+array[1][1]*array[1][0];
        array[1][1]=array[1][0]*array[0][1]+array[1][1]*array[1][1];
        return array;
    }*/

    public static void main(String args[]){
        fibonacci10 f =new fibonacci10();
        System.out.println(f.fibanacciv1(10));
    }
}
