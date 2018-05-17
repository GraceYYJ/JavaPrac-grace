package jianzhiOffer;

/**
 * Created by Administrator on 2018/5/15.
 */
public class FirstNotReapeatChar50 {
    public static void main(String[] args) {
        char chars[]={'!','!','#','&'};
        for(int i=0;i<chars.length;i++){
            Insert(chars[i]);
        }
        System.out.println(FirstAppearingOnce());
    }
    static int count[]=new int[256];
    //Insert one char from stringstream
    static int index=1;
    public static void Insert(char ch)
    {
        if(count[ch]==0){
            count[ch]=index++;
        }
        else{
            count[ch]=-1;
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        int temp=Integer.MAX_VALUE;
        char ch='#';
        for(int i=0;i<256;i++){
            if(count[i]!=0&&count[i]!=-1&&count[i]<temp){
                temp=count[i];
                ch=(char)i;
            }
        }
        return ch;
    }
}
