package jianzhiOffer;
import interview.linkedlist.LinkedList;
/**
 * Created by Administrator on 2018/5/15.
 */
public class deleteDuplication {
    public static void main(String[] args) {
        LinkedList head=new LinkedList(1);
        LinkedList second=new LinkedList(2);
        LinkedList third=new LinkedList(3);
        LinkedList fourth=new LinkedList(3);
        LinkedList fifth=new LinkedList(4);
        LinkedList sixth=new LinkedList(4);
        LinkedList tail=new LinkedList(5);
        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=tail;
        tail.next=null;
        System.out.println(deleteDuplicate(head));
    }
    public static LinkedList deleteDuplicate(LinkedList pHead) {
        if(pHead==null)
            return null;
        LinkedList p=pHead;
        LinkedList q=pHead.next;
        //找头结点
        while(q!=null&&p.data==q.data) {
            p = q.next;
            q = p.next == null ? null : p.next;
        }
        pHead=p;
        LinkedList pHead2=pHead;
        //继续遍历
        while(q!=null){
            if(p.data!=q.data){
                p=p.next;
                q=q.next;
                continue;
            }
            while(p.data==q.data){
                q=q.next;
            }
            pHead2.next=q;
            pHead2=pHead2.next;
            p=q;
            q=(q==null?null:q.next);
        }
        return pHead;
    }
}
