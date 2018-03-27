package OnlineJudge.meituan;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/22.
 */
public class subStringsum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String S=scanner.next();
        String T=scanner.next();
        int slength=S.length();
        int tlength=T.length();
        char Schar[]=S.toCharArray();
        char Tchar[]=T.toCharArray();
        int result=0;
        if(slength>=tlength) {
            int i=0;
            while(i+tlength<=slength){
                for(int j=0;j<tlength;j++){
                    if(Schar[j+i]!=Tchar[j])
                        result++;
                }
                i++;
            }
        }
        System.out.println(result);
    }
}
