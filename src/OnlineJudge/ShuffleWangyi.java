package OnlineJudge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/29.
 */
public class ShuffleWangyi {
    ArrayList<Integer> input=new ArrayList<>();
    ArrayList<ArrayList<Integer>> output=new ArrayList<>();
    public ArrayList<Integer> Shuffle(ArrayList<Integer> input,int n,int k){
        output.add(0,input);
        if(k>n) k=k%(n+1);
        for(int i=1;i<=k;i++){
            ArrayList<Integer> temp2=output.get(i-1);
            ArrayList<Integer> temp=new ArrayList<>();
            int index=0;
            for(int j=0;j<n;j++){
                temp.add(temp2.get(j));
                temp.add(temp2.get(j+n));
                index=index+2;
            }
            output.add(temp);
        }
        return output.get(k);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<t;i++){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            scanner.nextLine();
            ArrayList<Integer> input=new ArrayList<>();
            for(int j=0;j<2*n;j++){
                input.add(scanner.nextInt());
            }
            ArrayList<Integer> output=new ShuffleWangyi().Shuffle(input,n,k);
            result.add(output);
        }
        Iterator<ArrayList<Integer>> iterator=result.iterator();
        while(iterator.hasNext()){
           Iterator<Integer> iterator2=iterator.next().iterator();
            while(iterator2.hasNext()){
                System.out.print(iterator2.next()+" ");
            }
            System.out.println();
        }
    }
}
