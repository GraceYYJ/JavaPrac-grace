package leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2017/9/6.
 */
public class Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int val;
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        try{
            if(stack2.empty()){
                throw new Exception("队列为空");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        val=stack2.pop();
        return val;
    }
    public static void main(String args[]){
        Queue queue=new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
