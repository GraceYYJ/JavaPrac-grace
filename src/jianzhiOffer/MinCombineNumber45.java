package jianzhiOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2018/3/5.
 */
class Node{
    int number;
    Node(int number){
        this.number=number;
    }
}
public class MinCombineNumber45 {
    public String PrintMinNumber(int [] numbers) {
        Node nodes[]=new Node[numbers.length];
        for(int i=0;i<numbers.length;i++){
            nodes[i]=new Node(numbers[i]);
        }
        Arrays.sort(nodes,new Comparator<Node>(){
            @Override
            public int compare(Node num1,Node num2){
                String combine12=Integer.toString(num1.number)+Integer.toString(num2.number);
                String combine21=Integer.toString(num2.number)+Integer.toString(num1.number);
                return combine12.compareTo(combine21);
            }
        });
        StringBuilder stringbuilder=new StringBuilder();
        for(int i=0;i<nodes.length;i++){
            stringbuilder.append(nodes[i].number);
        }
        return stringbuilder.toString();
    }

    public static void main(String[] args) {
        int numbers[]={1,23,123,321};
        System.out.println(new MinCombineNumber45().PrintMinNumber(numbers));
    }
}
