package jianzhiOffer;
import java.util.Stack;
/**
 * Created by Administrator on 2017/12/4.
 */
public class minStack30 {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    public void push(int node) {
    stack1.push(node);
    if(stack2.empty())
        stack2.push(node);
    else {
        int min=stack2.peek()<node?stack2.peek():node;
        stack2.push(min);
    }
    }

    public void pop() {
        assert (!stack1.empty()&&!stack2.empty());
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
