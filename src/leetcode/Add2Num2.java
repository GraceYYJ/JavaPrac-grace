package leetcode;
/**
 * Created by Administrator on 2018/3/25.
 */

public class Add2Num2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0),p=head;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode p1=l1,q1=l1.next,p2=l2,q2=l2.next;
        int carry=0;
        while(p1!=null||p2!=null){
            int val1=(p1==null?0:p1.val);
            int val2=(p2==null?0:p2.val);
            int sum=val1+val2+carry;
            p.next=new ListNode(sum%10);
            carry=sum/10;
            p=p.next;
            p1=(p1==null?p1:p1.next);
            p2=(p2==null?p2:p2.next);
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode Node1=new ListNode(5);
//        Node1.next=new ListNode(8);
//        Node1.next.next=new ListNode(3);
        ListNode Node2=new ListNode(5);
//        Node2.next=new ListNode(6);
//        Node2.next.next=new ListNode(4);
        System.out.println(new Add2Num2().addTwoNumbers(Node1,Node2));
    }
}
