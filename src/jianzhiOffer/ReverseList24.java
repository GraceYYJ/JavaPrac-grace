package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/24.
 */
public class ReverseList24 {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode reverseLinklist(ListNode head){
        if(head==null)  return null;
        if(head.next==null)  return head;
        return head;
    }

    public void reverse(ListNode head,ListNode pre,ListNode p){
            p=head.next;
            head.next=pre;
            pre=head;
            head=p;
    }
    public void printList(ListNode head){
        ListNode p=head;
        if(head==null) return;
        System.out.print(p.data+" ");
        while(p.next!=null){
            p=p.next;
            System.out.print(p.data+" ");
        }
        System.out.println();
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

        ListNode head2=new ListNode(1);
        head2.next=null;

        ListNode head3=null;

        ReverseList24 test=new ReverseList24();
        test.printList(head);
        test.printList(test.reverseLinklist(head2));
    }
}

