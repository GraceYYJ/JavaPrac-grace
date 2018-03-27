package jianzhiOffer;

/**
 * Created by GraceYang on 2018/3/5.
 */
public class FirstNotRepeatingChar50 {
    public int FirstNotRepeatingChar(String str) {
        if(str==null)
            return -1;
        int strnum[]=new int[256];
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(('A'<=c&&c<='Z')||('a'<=c&&c<='z'))
                strnum[(int)str.charAt(i)]++;
            else
                return -1;
        }
        for(int i=0;i<str.length();i++){
            if(strnum[(int)str.charAt(i)]==1){
                return i+1;
            }
        }
            return -1;
    }

    public static void main(String[] args) {
        System.out.print(new FirstNotRepeatingChar50().FirstNotRepeatingChar("abc?ba^ru"));
    }
}
