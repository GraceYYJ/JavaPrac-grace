package jianzhiOffer;

/**
 * Created by Administrator on 2018/5/14.
 */
public class matchstr19 {
    public static void main(String[] args) {
        char a[]={'a','a','a'};
        char b[]={'a','b','*','a','c','*','a'};
        System.out.println(match(a,b));
    }
    public static boolean match(char[] str,char[] pattern){
        if(str==null||pattern==null)
            return false;
        return matchcore(str,pattern,0,0);
    }
    public static boolean matchcore(char[] str,char[] pattern,int i,int j){
        if(i==str.length&&j==pattern.length)
            return true;

        if(i==str.length&&j!=pattern.length){
            while(j!=pattern.length){
                if(pattern[j]!='*'&&(j>=pattern.length-1||pattern[j+1]!='*'))
                    return false;
                j++;
            }
            return true;
        }

        if(i<str.length&&j==pattern.length)
            return false;

        if(j==pattern.length-1){
            if(str[i]==pattern[j]||pattern[j]=='.')
                return matchcore(str,pattern,i+1,j+1);
            else
                return false;
        }
        if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]!='*')
            return matchcore(str,pattern,i+1,j+1);
        if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]=='*')
            return  matchcore(str,pattern,i+1,j+2) ||
                    matchcore(str,pattern,i+1,j) ||
                    matchcore(str,pattern,i,j+2);
        if(pattern[j+1]=='*')
            return matchcore(str,pattern,i,j+2);
/*        if(j+1<pattern.length&&pattern[j+1]=='*'){
            if(str[i]==pattern[j]||(pattern[j]=='.'&&i<str.length))
                return  matchcore(str,pattern,i+1,j+2) ||
                        matchcore(str,pattern,i+1,j) ||
                        matchcore(str,pattern,i,j+2);
        }
        if(str[i]==pattern[j]||(pattern[j]=='.'&&i<str.length))
            return matchcore(str,pattern,i+1,j+1);*/
        return false;
    }
}
