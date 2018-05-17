package OnlineJudge.meituan;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/20.
 */
public class numbit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long in[]=new long[n];
        for(int i=0;i<in.length;i++){
            in[i]=scanner.nextInt();
        }
        for(int i=0;i<in.length;i++){
            System.out.println(getnumbit(in[i]));
        }
    }
    public static String getnumbit(long num){
        long result[]=new long[10];
        for(int i=0;i<result.length;i++){
            result[i]=(long)(9*Math.pow(10,i));
        }
        String numstr=Long.toString(num);
        int length=numstr.length();
        long numbit=0;
        int i=0;
        while(i<length-1){
            numbit+=result[i];
            i++;
        }
        long k=(long)(num-Math.pow(10,length-1)+1);
        //long others=k*length;
        String lenstr=Long.toString(length);
        String numbitstr=Long.toString(numbit);
        String kstr=Long.toString(k);
        String finalres=multiply(lenstr,kstr);
        finalres=Add(numbitstr,finalres);
        //numbit+=others;
        //return numbit;
        return finalres;
    }
    public static String multiply(String num1, String num2){
        int result[]=new int[num1.length()+num2.length()];
        for(int i=0; i<num1.length();i++) {
            for (int j=0;j<num2.length();j++) {
                result[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        for(int i=result.length-1;i>0;i--){
            if (result[i]>=10) {
                result[i-1]+=result[i]/10;
                result[i]%=10;
            }
        }
        String results = "";
        boolean carry = false;
        for(int i=0;i<result.length;i++) {
            if (carry||result[i]!=0){
                carry=true;
                results+=result[i];
            }
        }
        return results.equals("")?"0":results;
    }

    public static String Add(String f, String s) {
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            result[i] = aint + bint;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for (int i = len; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
