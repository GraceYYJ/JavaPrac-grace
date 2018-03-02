package jianzhiOffer;

import java.util.Arrays;

/**
 * Created by GraceYang on 2018/3/1.
 */
public class IsContinuous61 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length<=0)
            return false;
        //Arrays.sort(numbers);
        quicksort(numbers,0,numbers.length-1);
        int i=0;
        while(numbers[i]==0){
            i++;
        }
        int numberOfZero=i;
        int jiange=0;
        for(int j=numberOfZero;j<numbers.length-1;j++){
            if(numbers[j]==numbers[j+1])
                return false;
            if(numbers[j+1]-numbers[j]>1){
                jiange=numbers[j+1]-numbers[j]-1;
                numberOfZero=numberOfZero-jiange;
            }
        }
        if(numberOfZero<0)
            return false;
        else
            return true;
    }
    public void quicksort(int []numbers,int s,int t){
        int i=s,j=t;
        int temp;
        if(s<t){
            temp=numbers[s];
            while(i!=j){
                while(j>i&&numbers[j]>=temp)
                    j--;
                numbers[i]=numbers[j];
                while(i<j&&numbers[i]<=temp)
                    i++;
                numbers[j]=numbers[i];
            }
            numbers[i]=temp;
        }
        else
            return;
        quicksort(numbers,s,i-1);
        quicksort(numbers,i+1,t);
    }

    public static void main(String[] args) {
        int numbers[]={1,0,4,0,6,0};
        System.out.println(new IsContinuous61().isContinuous(numbers));
    }
}

