package jianzhiOffer;

/**
 * Created by GraceYang on 2018/1/7.
 */
public class strToint68 {
    public int srtToint(String str){
        long num=0;
        int length=str.length();
        int start=0;
        boolean validstr=true;
        if(length<=0) {
            validstr=false;
            return 0;
        }
        if(str.charAt(0)=='+'||str.charAt(0)=='-'){
            start++;
        }
        for(int i=start;i<length;i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                num=num*10+str.charAt(i)-'0';
                if(num-1>0x7fffffff||num+1<=0x80000000){
                    validstr=false;
                    return 0;
                }
            }
            else{
                validstr=false;
                return 0;
            }
        }
        if(str.charAt(0)=='-')
            num=-num;
//        Long NUM=new Long(num);
//        int lastnum=NUM.intValue();
        int lastnum=(int)num;
        return lastnum;
    }
//public int StrToInt(String str)
//{
//    if (str.equals("") || str.length() == 0)
//        return 0;
//    char[] a = str.toCharArray();
//    int fuhao = 0;
//    if (a[0] == '-')
//        fuhao = 1;
//    int sum = 0;
//    for (int i = fuhao; i < a.length; i++)
//    {
//        if (a[i] == '+')
//            continue;
//        if (a[i] < 48 || a[i] > 57)
//            return 0;
//        sum = sum * 10 + a[i] - 48;
//    }
//    return fuhao == 0 ? sum : sum * -1;
//}

    public static void main(String[] args) {
        strToint68 test=new strToint68();
        System.out.println(test.srtToint("-2147483648888"));
    }
}
