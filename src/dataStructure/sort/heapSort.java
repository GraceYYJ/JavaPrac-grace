package dataStructure.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/1/23.
 */
public class heapSort {
    //筛选-大根堆
    void sift(int A[],int low,int high){
        int i=low,j=2*i;
        //将第0位用作tmp;
        A[0]=A[i];
        while(j<=high){
            if(j<high&&A[j]<A[j+1])
                j++;
            if(A[0]<A[j]){
                A[i]=A[j];
                i=j;
                j=2*i;
            }
            else break;
        }
        A[i]=A[0];
    }

    void heapsort(int A[]){
        int i;
        int n=A.length-1;
        //循环建立初始堆
        for(i=n/2;i>=1;i--){
            sift(A,i,n);
        }
        //进行n-1趟排序：（1）将第一个（根）元素的值与未排序区的最后一个元素交换（2）筛选剩余节点
        for(i=n;i>=2;i--){
            A[0]=A[i];
            A[i]=A[1];
            A[1]=A[0];
            sift(A,1,i-1);
        }
    }

    public static void main(String[] args) {
        int array[]=new int[]{0,7,3,9,8,5,2,1,6};
        heapSort test=new heapSort();
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        test.heapsort(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
