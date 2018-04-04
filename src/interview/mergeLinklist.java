package interview;

/**
 * Created by Administrator on 2018/4/3.
 */
public class mergeLinklist {
    public LinkedList merge(LinkedList head1,LinkedList head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        LinkedList p1=head1;
        LinkedList p2=head2;
        LinkedList mergehead=null;
        if(p1.data<p2.data){
            mergehead=p1;
            p1.next=merge(p1.next,p2);
        }
        else {
            mergehead=p2;
            p1.next=merge(p1,p2.next);
        }
        return mergehead;
    }
}
