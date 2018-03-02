package jianzhiOffer;

/**
 * Created by GraceYang on 2018/2/7.
 */
public class NumberAppearOnce56 {
    public int findNumberAppearOnce(int array[]){
        if(array.length<=0)
            return -1;
        int bitsum[]=new int[32];
        for(int i=0;i<array.length;i++){
            int mask=1;
            for(int j=31;j>=0;j--){
                int temp=array[i]&mask;
                if(temp!=0)
                    bitsum[j]+=1;
                mask=mask<<1;
            }
        }
        int result=0;
        for(int i=0;i<32;i++){
            //bitsum[i]=bitsum[i]%3;
            //System.out.print(bitsum[i]+" ");
            result=result<<1;
            result+=bitsum[i]%3;
        }
        return result;
    }

    public static void main(String[] args) {
        int array[]={1,2,3,3,2,1,3,5,2,1};
        System.out.println(new NumberAppearOnce56().findNumberAppearOnce(array));
    }
}
