package jianzhiOffer;

/**
 * Created by Administrator on 2018/5/14.
 */
public class IsNumeric20 {
    public static void main(String[] args) {
        char number[]={'+','5','.','-'};
        System.out.println(isNumeric(number));
    }
    public static int point=0;
    public static boolean isNumeric(char str[]){
        if(str.length<=0) return false;
        boolean numeric=ScanInteger(str);
        if(point<str.length&&str[point]=='.'){
            point++;
            numeric=ScanUnsignedInteger(str)||numeric;
        }
        if(point<str.length&&(str[point]=='e'||str[point]=='E')){
            point++;
            numeric=numeric&&ScanInteger(str);
        }
        return numeric&&point==str.length;
    }
    public static boolean ScanInteger(char str[]){
        if(point<str.length&&(str[point]=='+'||str[point]=='-'))
            point++;
        return ScanUnsignedInteger(str);
    }
    public static boolean ScanUnsignedInteger(char str[]){
        int tag=point;
        while(point<str.length&&str[point]>='0'&&str[point]<='9')
            point++;
        return point>tag;
    }
    public static boolean isNumeric2(char str[]){
        String s=String.valueOf(str);
        //return s.matches("[+-]?[0-9]*(.[0-9]*)?([eE][+-]?[0-9]+)?");
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}
