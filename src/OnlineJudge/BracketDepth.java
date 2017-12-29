package OnlineJudge;

import java.util.Scanner;
/**
 * Created by Administrator on 2017/12/19.
 */
public class BracketDepth {
    public int bracketDepth(String brackets){
        int length=brackets.length();
        int maxDepth=0;
        int temp=0;
        for(int i=0;i<length;i++){
            if(brackets.charAt(i)=='(')
                temp++;
            if(brackets.charAt(i)==')')
                temp--;
            if(temp>maxDepth)
                maxDepth=temp;
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String brackets=scanner.nextLine();
        BracketDepth test=new BracketDepth();
        System.out.println(test.bracketDepth(brackets));
    }
}
