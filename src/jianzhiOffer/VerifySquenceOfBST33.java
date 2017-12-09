package jianzhiOffer;

/**
 * Created by Administrator on 2017/12/4.
 */
public class VerifySquenceOfBST33 {
    public boolean VerifySquence(int[] sequence){
        if(sequence.length<=0)  return false;
        int length=sequence.length;
        return VerifySquenceOfBST(sequence,0,length);
    }
    public boolean VerifySquenceOfBST(int[] sequence,int start,int length){
        int root=sequence[length-1];
        int i=start;
        for(;i<length-1;i++){
            if(sequence[i]>root)
                break;
        }
        int j=i;
        for(;j<length-1;j++){
            if(sequence[j]<root)
                return false;
        }
        boolean left=true;
        if(i>0) left=VerifySquenceOfBST(sequence,0,i);
        boolean right=true;
        if(i<length-1)  right=VerifySquenceOfBST(sequence,i+1,length-i-1);

        return left&&right;
    }

    public static void main(String[] args) {
        VerifySquenceOfBST33 test=new VerifySquenceOfBST33();
        int sequence1[]={5,7,6,9,11,10,8};
        int sequence2[]={7,4,6,5};
        System.out.println(test.VerifySquence(sequence1));
        System.out.println(test.VerifySquence(sequence2));
    }
}
