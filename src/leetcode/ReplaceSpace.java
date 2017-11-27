package leetcode;

/**
 * Created by Administrator on 2017/8/29.
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int spacecount = 0;
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' ') {
                spacecount++;
            }
        }
        int newlength=str.length()+2*spacecount;
        int indexold=str.length()-1;
        int indexnew=newlength-1;
        str.setLength(newlength);
        while(indexnew>indexold && indexold>=0){
            if(str.charAt(indexold)==' '){
                str.setCharAt(indexnew--,'0');
                str.setCharAt(indexnew--,'2');
                str.setCharAt(indexnew--,'%');
            }
            else{
                str.setCharAt(indexnew--,str.charAt(indexold));
            }
            indexold--;
        }
        return str.toString();
    }
    public static void main(String args[]){
        System.out.println(new ReplaceSpace().replaceSpace(new StringBuffer(" hello")));
    }
}
