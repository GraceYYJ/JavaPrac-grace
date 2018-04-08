package OnlineJudge.Tencent;

import java.util.*;

/**
 * Created by Administrator on 2018/4/5.
 */
public class songs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        int alen=scanner.nextInt();
        int anum=scanner.nextInt();
        int blen=scanner.nextInt();
        int bnum=scanner.nextInt();
        HashMap<Integer,Integer> resultmap=new HashMap<>();
        for(int i=0;i<=anum;i++){
            for(int j=0;j<bnum;j++){
                if(alen*i+blen*j==k){
                    resultmap.put(i,j);
                }
            }
        }
        long result=0;
        for(Map.Entry<Integer,Integer> entry:resultmap.entrySet()){
            int a=entry.getKey();
            int b=entry.getValue();
            long tempa=getCombination(a,anum);
            long tempb=getCombination(b,bnum);
            result=result+tempa*tempb;
        }
        long resultmod=result%1000000007;
        System.out.println(resultmod);
    }
    public static long getCombination(int z,int c){
        if(z==0)
            return 1;
        if(z==1)
            return c;
        long zf=getFactorial(z);
        long cminuszf=getFactorial(c-z);
        long cf=getFactorial(c);
        return cf/(zf*cminuszf);
    }
    public static long getFactorial(int x){
        if(x==0)
            return 1l;
        return x*getFactorial(x-1);
    }
}
