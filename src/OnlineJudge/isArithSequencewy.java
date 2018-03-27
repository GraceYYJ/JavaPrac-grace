package OnlineJudge;

/**
 * Created by GraceYang on 2018/3/8.
 */
import java.util.Scanner;
public class isArithSequencewy{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        int inputnum[]=new int[length];
        for(int i=0;i<length;i++){
            inputnum[i]=sc.nextInt();
        }
        isArithSequencewy test=new isArithSequencewy();
        if(test.isArithSeq(inputnum))
            System.out.println("Possible");
        else
            System.out.println("Impossible");
    }
    public boolean isArithSeq(int seq[]){
        if(seq.length<=0){
            return false;
        }
        if(seq.length==1){
            return true;
        }
        quicksort(seq,0,seq.length-1);
        int diff=seq[1]-seq[0];
        for(int i=1;i<seq.length-1;i++){
            if(seq[i+1]-seq[i]!=diff)
                return false;
        }
        return true;
    }
    public void quicksort(int seq[],int s,int t){
        int i=s,j=t;
        int flag=seq[i];
        if(i>=j||seq.length<=0)
            return;
        while(i<j){
            while(seq[j]>=flag&&j>i)
                j--;
            seq[i]=seq[j];
            while(seq[i]<=flag&&i<j)
                i++;
            seq[j]=seq[i];
        }
        seq[i]=flag;
        quicksort(seq,i+1,t);
        quicksort(seq,s,i-1);
    }
}