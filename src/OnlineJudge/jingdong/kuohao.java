package OnlineJudge.jingdong;

/**
 * Created by Administrator on 2018/4/9.
 */
import java.util.Scanner;

public class kuohao{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;++i) {
            System.out.println(canswapwork(scanner.nextLine()));
        }
    }

    public static String canswapwork(String str){
        int l=0,r=0,dis=0;
        for(int i=0;i<str.length();++i){
            if(str.charAt(i)=='(')
                l++;
            else{
                r++;
                if(r > l){
                    int temp=r-l;
                    dis=dis>temp?dis:temp;
                }
            }
        }
        if((l!=r)||dis>2)
            return "No";
        return "Yes";
    }
}

