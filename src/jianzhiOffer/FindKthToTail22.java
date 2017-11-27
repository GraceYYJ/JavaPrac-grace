package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/23.
 */
public class FindKthToTail22 {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public int findLastKth(ListNode head,int k){
        if(k==0) return -1;
        ListNode p=head;
        int i=1;
        while(i<k&&p.next!=null){
            p=p.next;
            i++;
        }
        if(i!=k) return -1;
        ListNode q=head;
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        return q.data;
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k==0) return null;
        ListNode p=head;
        int i=1;
        while(i<k){
            if(p.next!=null) {
                p = p.next;
                i++;
            }
            else
                return null;
        }
        ListNode q=head;
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        return q;
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
        fourth.next=fifth;
        fifth.next=tail;
        tail.next=null;

        System.out.println(new FindKthToTail22().findLastKth(head,0));
        System.out.print(new FindKthToTail22().FindKthToTail(head,2));
    }
}

