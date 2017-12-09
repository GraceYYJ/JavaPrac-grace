package jianzhiOffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/6.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Clone35 {
    public RandomListNode[] createListNode(int array[]){
        RandomListNode head=new RandomListNode(array[0]);
        RandomListNode p=head;
        RandomListNode pointers[]=new RandomListNode[array.length];
        pointers[0]=p;
        for(int i=1;i<array.length;i++){
            p.next=new RandomListNode(array[i]);
            p=p.next;
            pointers[i]=p;
        }
        return pointers;
    }
    public void printRLNode(RandomListNode head){
        RandomListNode p=head;
        RandomListNode q=head;
        System.out.println("=========分割线=========");
        while(p!=null){
            System.out.print(p.label+"->");
            p=p.next;
        }
        System.out.print("null");
        System.out.println();
        while(q!=null){
            if(q.random!=null){
                System.out.println(q.label+"=>"+q.random.label);
            }
            q=q.next;
        }
        System.out.println();
    }

    public RandomListNode Clone1(RandomListNode pHead){
        if(pHead==null)
            return null;
        Map<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode p1=pHead;
        RandomListNode qhead=new RandomListNode(pHead.label);
        RandomListNode q1=qhead;
        map.put(p1,q1);
        while(p1.next!=null){
            q1.next=new RandomListNode(p1.next.label);
            p1=p1.next;
            q1=q1.next;
            map.put(p1,q1);
        }
        Iterator<Map.Entry<RandomListNode, RandomListNode>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<RandomListNode, RandomListNode> entry = iterator.next();
            if(entry.getKey().random!=null){
                entry.getValue().random=map.get(entry.getKey().random);
            }
        }
        return qhead;
    }
    public RandomListNode Clone2(RandomListNode pHead){
        if(pHead==null)
            return null;
        RandomListNode p=pHead;
        RandomListNode q=p.next;
        CloneNodes(pHead);
        CloneRandomP(pHead);
        return getClonelist(pHead);
    }
    public void CloneNodes(RandomListNode pHead){
        RandomListNode p=pHead;
        RandomListNode q=p.next;
        while(p!=null){
            p.next=new RandomListNode(p.label);
            p.next.next=q;
            p=p.next.next;
            if(p!=null)
                q=q.next;
        }
    }
    public void CloneRandomP(RandomListNode pHead){
        RandomListNode p=pHead;
        RandomListNode q=p.next;
        while(p!=null){
            if(p.random!=null)
                q.random=p.random.next;
            p=p.next.next;
            if(p!=null)
                q=p.next;
        }
    }
    public RandomListNode getClonelist(RandomListNode pHead){
        RandomListNode p=pHead;
        RandomListNode qHead=p.next;
        RandomListNode q=qHead;
        while(p!=null){
            p.next=p.next.next;
            if(q.next!=null)
                q.next=q.next.next;
            p=p.next;
            if(p!=null)
                q=q.next;
        }
        return qHead;
    }
    public static void main(String[] args) {
        Clone35 test=new Clone35();
        int array1[]={1,2,3,4,5};
        RandomListNode pointers[]=test.createListNode(array1);
        pointers[0].random=pointers[2];
        pointers[1].random=pointers[4];
        pointers[3].random=pointers[1];
        test.printRLNode(pointers[0]);
        RandomListNode qhead=test.Clone2(pointers[0]);
        test.printRLNode(qhead);

        int array2[]={1};
        RandomListNode pointers2[]=test.createListNode(array2);
        pointers2[0].random=pointers2[0];
        test.printRLNode(pointers2[0]);
        RandomListNode qhead2=test.Clone1(pointers2[0]);
        test.printRLNode(qhead2);
    }
}
