package jianzhiOffer;

/**
 * Created by Administrator on 2017/10/25.
 */
public class minofRotatearr {
    public int minNumberInRotateArray(int [] array) {
        int i=0;
        while(array[i]<=array[i+1]){
            i++;
        }
        if(array[i]>array[i+1]){
            return array[i+1];
        }
        else return 0;
    }
    public static void main(String args[]){
        minofRotatearr m =new minofRotatearr();
        int a[]={1,1,1,0,1};
        System.out.println(m.minNumberInRotateArray(a));
    }
}
