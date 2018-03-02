package jianzhiOffer;

import java.util.ArrayList;

/**
 * Created by GraceYang on 2018/3/2.
 */
public class LastRemaining62 {
    public int LastRemaining_Solution(int n, int m) {
        if(n<=0||m<=0)
            return -1;
        ArrayList<Integer> list=new ArrayList();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int current=0;
        while(list.size()>1){
            for(int i=0;i<m-1;i++){
                if(current==list.size()-1){
                    current=0;
                }
                else
                    current++;
            }
            if(current==list.size()-1){
                list.remove(current);
                current=0;
            }
            else
                list.remove(current);
        }
        return list.get(current);
    }
    public int LastRemaining_Solution2(int n, int m) {
        if(n <= 0 || m <= 0)
            return -1;
        else{
            if(n==1)
                return 0;
            else {
                return (LastRemaining_Solution2(n-1,m)+m)%n;
            }
        }
    }
    public int LastRemaining_Solution3(int n, int m) {
        if(n <= 0 || m <= 0)
            return -1;
        int last=0;
        for(int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
    public static void main(String[] args) {
        System.out.println(new LastRemaining62().LastRemaining_Solution3(5,3));
    }
}
