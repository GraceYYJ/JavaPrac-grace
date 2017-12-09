package jianzhiOffer;

import java.util.Stack;

/**
 * Created by Administrator on 2017/12/4.
 */
public class popOrder31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean ispoporder=false;
        Stack<Integer> stack=new Stack<>();
        int j=0;
        int length=popA.length;
        if(pushA.length<=0||popA.length<=0||pushA.length!=popA.length)
            return false;
        for(int i=0;i<length;i++){
            if(stack.empty()){
                stack.push(pushA[j]);
                j++;
            }
            while(stack.peek()!=popA[i]&&j<length){
                stack.push(pushA[j]);
                j++;
            }
            if(!stack.empty()&&stack.peek()==popA[i])
                stack.pop();
        }
        if(stack.empty()) ispoporder=true;
        return ispoporder;
    }

    public static void main(String[] args) {
        popOrder31 test=new popOrder31();
        int pushA[]={1,2,3,4,5};
        int popA[]={4,5,3,2,1};
        System.out.println(test.IsPopOrder(pushA,popA));
    }
}
