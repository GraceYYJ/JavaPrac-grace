package jianzhiOffer;

import interview.linkedlist.LinkedList;

/**
 * Created by Administrator on 2018/4/14.
 */
public class circlelist23 {
    public static LinkedList hascircle(LinkedList head){
        if(head==null||head.next==null)
            return null;
        LinkedList quick=head;
        LinkedList slow=head;
        while(quick!=null&&slow!=null){
            slow=slow.next;
            quick = quick.next == null ? null : quick.next.next;
            if(quick==slow)
                return quick;
        }
        return null;
    }
    public static int circlelength(LinkedList head){
        LinkedList point=hascircle(head);
        LinkedList quick=point;
        LinkedList slow=point;
        if(point==null)
            return -1;
        quick=quick.next;
        int length=1;
        while(true){
            if(quick==slow){
                return length;
            }
            slow=slow.next;
            quick=quick.next.next;
            length++;
        }
    }
    public static LinkedList getjoinpoint(LinkedList head){
        LinkedList point=hascircle(head);
        if(point==null)
            return null;
        LinkedList p1=point;
        LinkedList p2=head;
        while(true){
            if(p1==p2)
                return p1;
            p1=p1.next;
            p2=p2.next;
        }
    }

    public static void main(String[] args) {
        LinkedList head=new LinkedList(1);
/*        head.next=new LinkedList(2);
        head.next.next=new LinkedList(3);
        head.next.next.next=new LinkedList(4);
        head.next.next.next.next=head.next;*/
        System.out.print(getjoinpoint(head));
    }
}
