package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/22.
 */
public class ISNumeric {
    public int p;

    public boolean isNumeric(char[] str){
        p=0;
        if(str.length<=0)
            return false;
        boolean flag=ScanInteger(str);
        if(str[p]=='.'){
            p++;
            flag=ScanUnsignedInteger(str)||flag;
        }
        if(str[p]=='e'||str[p]=='E'){
            p++;
            flag=flag&&ScanInteger(str);
        }
        return flag&&p==str.length;
    }

    public boolean ScanInteger(char[] str){
        if(p<str.length&&(str[p]=='+'||str[p]=='-'))
            p++;
        return ScanUnsignedInteger(str);
    }
    public boolean ScanUnsignedInteger(char[] str){
        int q=p;
        while(p<str.length&&str[p]>='0'&&str[p]<'9')
            p++;
        return p>q;
    }

    public static void main(String[] args) {
        char str1[]={'1','2','3','.','4','5','e','+','6'};
        char str2[]={'1','2','e'};
        char str3[]={'.','e','6'};
        char str4[]={'3','f'};
        char str5[]={};
        System.out.println(new ISNumeric().isNumeric(str1));
        System.out.println(new ISNumeric().isNumeric(str2));
        System.out.println(new ISNumeric().isNumeric(str3));
        System.out.println(new ISNumeric().isNumeric(str4));
        System.out.println(new ISNumeric().isNumeric(str5));

    }
}
