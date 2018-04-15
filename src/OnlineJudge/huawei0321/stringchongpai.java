package OnlineJudge.huawei0321;

import java.util.Scanner;
/**
 * Created by GraceYang on 2018/4/10.
 */
public class stringchongpai{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        char ch1[]=new char[128];
        char ch2[]=new char[128];
        for(char c:str.toCharArray()){
            ch1[c]++;
        }
        int i=0;
        char temp;
        String result="";
        for(int count=0;count<str.length();i=(i+1)%128){
            if(ch2[i]<ch1[i]){
                result=result+(char)i;
                ch2[i]++;
                count++;
            }
        }
        System.out.println(result);
        /*char chars[][]=new char[128][2];
        String result="";
        int i=0,c=0;
        char temp;
        for(int count=0;count<str.length();i=(i+1)%128){
            if (chars[i][1]<chars[i][0]) {
                temp=(char)(i+'\0');
                result+=temp;
                chars[i][1]++;
                count++;
            }
        }*/
        //System.out.println(result);
    }
}
