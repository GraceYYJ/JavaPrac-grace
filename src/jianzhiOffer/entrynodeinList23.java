package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/23.
 */
public class entrynodeinList23 {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }
    public int LoopLength=1;

    public boolean existLoop(ListNode head){
        if(head==null||head.next==null||head.next.next==null)
            return false;
        ListNode p=head.next.next;
        ListNode q=head;
        while(p!=q){
            if(p.next==null||p.next.next==null)
                return false;
            else
                p=p.next.next;
                q=q.next;
        }
        ListNode flag=p;
        while(p.next!=flag){
            LoopLength++;
            p=p.next;
        }
        return true;
    }

    public int EntryNode(ListNode head){
        ListNode p=head;
        ListNode q=head;
        if(!existLoop(head))
            return -1;
        else{
            for(int i=0;i<LoopLength;i++)
                p=p.next;
            while(p!=q){
                p=p.next;
                q=q.next;
            }
            return p.data;
        }
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
        tail.next=first;

        System.out.println(new entrynodeinList23().EntryNode(head));
    }
}
