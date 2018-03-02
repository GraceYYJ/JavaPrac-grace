package jianzhiOffer;

/**
 * Created by GraceYang on 2018/2/7.
 */
public class ReverseSentence58 {
    public String Reverse(String str,int start,int end){
        StringBuffer newstr=new StringBuffer();
        for(int i=end;i>=start;i--){
            newstr.append(str.charAt(i));
        }
        return newstr.toString();
    }
    public String ReverseSentence(String setence){
        if(setence.length()<=0)
            return setence;
        String reversesentence=Reverse(setence,0,setence.length()-1);
        StringBuffer newsentence=new StringBuffer();
        int i=0;
        int j=0;
        while(j<reversesentence.length()){
            if(reversesentence.charAt(j)==' '){
               i=j+1;
               j=j+1;
            }
            while(j<reversesentence.length() && reversesentence.charAt(j)!=' '){
                j++;
            }
            newsentence.append(Reverse(reversesentence,i,j-1));
            newsentence.append(' ');
        }
        newsentence.deleteCharAt(newsentence.length()-1);
        return newsentence.toString();
    }
    public String LeftRotateString(String str,int n) {
        String reversesentence=Reverse(str,0,str.length()-1);
        StringBuffer newsentence=new StringBuffer();
        if(n>str.length())
            return newsentence.toString();
                    newsentence.append(Reverse(reversesentence,0,reversesentence.length()-1-n));
        newsentence.append(Reverse(reversesentence,reversesentence.length()-n,reversesentence.length()-1));
        return newsentence.toString();
    }
    public static void main(String[] args) {
        String str1="I am a student.";
        System.out.println(new ReverseSentence58().ReverseSentence(str1));
//        System.out.println(new ReverseSentence58().LeftRotateString(str1,3));

    }
}
