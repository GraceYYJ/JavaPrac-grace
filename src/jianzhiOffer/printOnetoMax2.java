/*
package jianzhioffer;

import java.util.Arrays;

*/
/**
 * Created by GraceYang on 2017/11/18.
 *//*

public class printOnetoMax {
    public void print1tomax(int n){
        if(n<=0)
            return;
        char[] number=new char[n+1];
        Arrays.fill(number,'0');
        while (!Increment(number)){
            printNumber(number);
        }
    }

    public boolean Increment(char[] number){
        boolean isOverflow=false;
        int nTakeOver=0;
        int nLength=number.length;
        for(int i=nLength-1;i>=0;i--){
            int nSum=number[i]-48;
            if(i==nLength-1)
                nSum++;
            if(nSum>=10){
                if(i==0)
                    isOverflow=true;
                else{
                    nSum-=10;
                    nTakeOver=1;
                    number[i]=(char)(nSum+48);
                }
            }
            else {
                number[i]=(char)(nSum+48);
                break;
            }
        }
        return isOverflow;
    }

    public void printNumber(char[] number){
        boolean isBeginning0=true;
        int nLength=number.length;

        for(int i=0;i<nLength;++i){
            if(isBeginning0&&number[i]!='0')
                isBeginning0=false;
            if(!isBeginning0)
                System.out.print(number[i]+' ');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printOnetoMax test=new printOnetoMax();
        test.print1tomax(3);
    }

}
*/
