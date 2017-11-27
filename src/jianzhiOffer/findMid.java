package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/23.
 */
public class findMid {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public int findMidData(ListNode head){
        if(head==null) return -1;
        ListNode p=head;
        ListNode q=head;
        while(p.next!=null){
            p=p.next;
            if(p.next!=null){
                p=p.next;
                q=q.next;
            }
            else
                //return q.data;
                return q.next.data;
        }
        return q.data;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode first=new ListNode(2);
        ListNode second=new ListNode(3);
        ListNode third=new ListNode(4);
        ListNode fourth=new ListNode(5);
        ListNode fifth=new ListNode(6);
        ListNode tail=new ListNode(7);
        head.next=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        //fourth.next=tail;
        fourth.next=fifth;
        fifth.next=tail;
        tail.next=null;

        System.out.println(new findMid().findMidData(head));
    }
}

