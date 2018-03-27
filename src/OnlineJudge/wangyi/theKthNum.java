package OnlineJudge.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2018/3/27.
 */
public class theKthNum {
    public static void main(String[] args) {
        //int a[]={1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        int a[]={11,41,56,22,31,55,78,7,3};
//        Arrays.sort(a);
//        System.out.println(a);
        int n=9;
        int K=6;
        System.out.println(new theKthNum().findKth(a,n,K));
    }
    public int findKth(int[] a, int n, int K){
        if(a.length<=0||K<0||K>a.length){
            return -1;
        }
        int start=0;
        int end=n-1;
        int index=partition(a,start,end);
        while(index!=K-1){
            if(index>K-1){
                end=index-1;
                index=partition(a,start,end);
            }
            else {
                start=index+1;
                index=partition(a,start,end);
            }
        }
        return a[K-1];
    }
    public int partition(int data[],int start,int end){
        if(data.length<=0||start<0||end<start){
            return -1;
        }
        //int index=(int)Math.random()*start+(end-start);
        int index=start+(end-start)/2;
        //System.out.println(index);
        swap(data,index,end);
        int small=start-1;
        for(index=start;index<end;index++){
            if(data[index]>data[end]){
                small++;
                if(small!=index)
                    swap(data,small,index);
            }
        }
        small++;
        swap(data,small,end);
        return small;
    }
    public void swap(int data[],int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
