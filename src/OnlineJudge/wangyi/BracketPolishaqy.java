package OnlineJudge.wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/6.
 */
public class BracketPolishaqy {
    public int poishBracket(String string){
        char charstr[]=string.toCharArray();
        int count1=0;
        int count2=0;
        for(int i=0;i<charstr.length;i++){
            if(charstr[i]=='(')
                count1++;
            if(charstr[i]==')'){
                if(count1==0)
                    count2++;
                else
                    count1--;
            }
        }
        return count1+count2;
        /*if(count<0)
            return -1;
        else
            return count;*/
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.next();
        System.out.println(new BracketPolishaqy().poishBracket(string));
    }
}
