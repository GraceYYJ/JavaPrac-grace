package interview;

/**
 * Created by Administrator on 2018/4/4.
 */
public class ReverseLinkedList {
    public static LinkedList Reverse(LinkedList head){
        if(head==null)
            return head;
        LinkedList p=head;
        if(p.next==null)
            return head;
        LinkedList q=p.next;
        LinkedList k=q.next;
        p.next=null;
        while(k!=null){
            q.next=p;
            p=q;
            q=k;
            k=k.next;
        }
        q.next=p;
        return q;
    }

    public static void main(String[] args) {
        LinkedList head=new LinkedList(1);
/*        head.next=new LinkedList(2);
        head.next.next=new LinkedList(3);*/
        LinkedList reversehead=Reverse(head);
        while(reversehead!=null){
            System.out.println(reversehead.data);
            reversehead=reversehead.next;
        }
    }
}
