package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/20.
 */

public class deleteNumInlinklist {
    private static class ListNode{
        int data;
        ListNode next;
        public ListNode(int data){
            this.data=data;
        }
    }
    public void deletenum1(ListNode head,ListNode i){
        ListNode p=head;
        while(p.next!=i){
            p=p.next;
        }
        p.next=i.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        ListNode fourth=new ListNode(4);
        ListNode fifth=new ListNode(5);
        ListNode tail=new ListNode(6);
        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=tail;
        tail.next=null;
        new deleteNumInlinklist().deletenum1(head,fourth);

    }
}
