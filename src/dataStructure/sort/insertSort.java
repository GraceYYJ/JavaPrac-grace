package dataStructure.sort;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by GraceYang on 2018/1/20.
 */
public class insertSort {
    void insertsort(int A[]){
        int i,j,temp;
        int n=A.length;
        for(i=1;i<n;i++){
            temp=A[i];
            if(A[i]<A[i-1]){
                for(j=i-1;j>=0&&temp<A[j];j--){
                    A[j+1]=A[j];
                }
                A[j+1]=temp;
            }
        }
    }
    void shellsort(int A[]){
        int d,i,j,temp;
        int n=A.length;
        for(d=n/2;d>=1;d=d/2){
            for(i=d;i<n;i++){
                if(A[i]<A[i-d]){
                    temp=A[i];
                    for(j=i-d;j>=0&&temp<A[j];j-=d){
                        A[j+d]=A[j];
                    }
                    A[j+d]=temp;
                }
            }
        }
    }

    void bubblesort(int A[]){
        int i,j,temp;
        for(i=0;i<A.length-1;i++){
            boolean flag=false;
            for(j=A.length-1;j>i;j--){
                if(A[j-1]>A[j]){
                    temp=A[j-1];
                    A[j-1]=A[j];
                    A[j]=temp;
                    flag=true;
                }
            }
            if(!flag) return;
        }
    }

    public static void main(String[] args) {
        int array[]={3,2,5,3,6,1,7};
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        insertSort sort=new insertSort();
        sort.bubblesort(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
