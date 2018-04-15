package OnlineJudge.huawei0321;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/22.
 */
public class longIntmultiply{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String num1=scanner.next();
        String num2=scanner.next();
        System.out.println(multiply(num1,num2));
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
}
