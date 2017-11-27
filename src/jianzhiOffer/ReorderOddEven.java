package jianzhiOffer;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/11/22.
 */
public class ReorderOddEven{
    public void reorder1(int[] array){
        if(array.length<=0)
            return;
        int p=0;
        int q=array.length-1;
        int temp;
        while(p<q){
            while(!isEven(array[p])&&p<array.length)
                p++;
            while(isEven(array[q])&&q>=0)
                q--;
            if(p<q){
                temp=array[q];
                array[q]=array[p];
                array[p]=temp;
            }
        }
    }

    public void reorder2(int [] array){
        boolean flag=true;
        int temp;
        while(flag){
            //for(int i=1;i<=array.length-1;i++){
            flag=false;
                for(int j=1;j<=array.length-1;j++){
                    if(isEven(array[j-1])&&!isEven(array[j])){
                        temp=array[j];
                        array[j]=array[j-1];
                        array[j-1]=temp;
                        flag=true;
                    }
                }
            //}
        }
    }

    public boolean isEven(int n){
        return (n&1)==0;
    }

    public static void main(String[] args) {
        int[] array={3,6,5,7,8,9,5,4,3,2};

        new ReorderOddEven().reorder2(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
            System.out.print(' ');
        }
    }
}
