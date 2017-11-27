package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/8/30.
 */
class ListNode{
    int val;
    ListNode next= null;

    ListNode(int val){
        this.val=val;
    }
}

public class printReverseLinklist {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*递归方法*/
        /*if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
            System.out.println(listNode.val);
        }*/
        /*遍历入栈出栈方法*/
        Stack<Integer> stack=new Stack<Integer>();
        ListNode p=listNode;
        while(p!=null){
            stack.push(p.val);
            p=p.next;
        }
        while(!stack.empty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static void main(String args[]){
        ListNode Node=new ListNode(1);
        Node.next=new ListNode(2);
        System.out.println(new printReverseLinklist().printListFromTailToHead(Node));
    }
}
