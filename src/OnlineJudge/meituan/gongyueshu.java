package OnlineJudge.meituan;

/**
 * Created by Administrator on 2018/4/20.
 */
import java.util.Scanner;
public class gongyueshu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int p=scanner.nextInt();
        int array[]=new int[N+1];
        array[1]=p;
        for(int i=2;i<N+1;i++)
            array[i]=(array[i-1]+153)&(p-1);
        long res = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                res+=array[greatCommonDivisor(i, j)];
            }
        }
        System.out.println(res);
    }
    private static int greatCommonDivisor(int a,int b) {
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        while(b!=0){
            int c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
}
