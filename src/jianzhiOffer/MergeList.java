package jianzhiOffer;

/**
 * Created by GraceYang on 2017/11/26.
 */
public class MergeList {
    public static class ListNode{
        int data;
        ListNode next;
        public ListNode(int data){
            this.data=data;
        }
    }
    public ListNode Merge(ListNode pHead1,ListNode pHead2){
        if(pHead1==null)
            return pHead2;
        if(pHead2==null)
            return pHead1;
        ListNode pMergedHead=null;

        if(pHead1.data<pHead2.data){
            pMergedHead=pHead1;
            pMergedHead.next=Merge(pHead1.next,pHead2);
        }
        else {
            pMergedHead=pHead2;
            pMergedHead.next=Merge(pHead1,pHead2.next);
        }
        return pMergedHead;
    }

    public void printList(ListNode head){
        ListNode p=head;
        if(p==null){
            System.out.print("null");
            return;
        }
        while(p.next!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.print(p.data+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        ListNode first=new ListNode(3);
        ListNode second=new ListNode(5);
        ListNode third=new ListNode(7);
        ListNode fourth=new ListNode(9);
        head1.next=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=null;

        ListNode head2=new ListNode(2);
        ListNode first2=new ListNode(4);
        ListNode second2=new ListNode(6);
        ListNode third2=new ListNode(8);
        head2.next=first2;
        first2.next=second2;
        second2.next=third2;
        third2.next=null;

        ListNode head3=new ListNode(10);
        head3.next=null;
        ListNode head4=new ListNode(10);
        head4.next=null;

        MergeList test=new MergeList();
        test.printList(test.Merge(head1,head2));
        test.printList(test.Merge(head3,head4));
        test.printList(test.Merge(null,null));

    }
}
