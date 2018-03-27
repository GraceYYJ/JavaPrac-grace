package genericity;

/**
 * Created by GraceYang on 2018/3/8.
 */
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int numbers[]=new int[n];
        //ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
        }
        int m=0,k=0;
        for(m=n-1;m>=0;m-=2){
            //list.add(numbers[m]);
            System.out.print(numbers[m]+" ");
        }
        if(m<=0)    k=1;
        else    k=0;
        for(;k<n;k+=2){
            //list.add(numbers[m]);
            if(k!=n-1&&k!=n-2)
                System.out.print(numbers[k]+" ");
            else
                System.out.print(numbers[k]);
        }
    }
}
