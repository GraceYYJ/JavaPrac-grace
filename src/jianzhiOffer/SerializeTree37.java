package jianzhiOffer;

import dataStructure.Tree.TreeNode;
import dataStructure.Tree.treeOper;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/12/9.
 */
public class SerializeTree37 {
    public void Serialize(TreeNode root){
        if(root==null){
            System.out.print("$ ");
            return;
        }
        System.out.print(root.val+" ");
        Serialize(root.left);
        Serialize(root.right);
    }
    public TreeNode DeSerialize(TreeNode root, Queue<String> queue){
/*        int num[]=new int[queue.size()];
        for(int i=0;i<num.length;i++){
            if(input[i].matches("\\d+")){
                num[i]=Integer.parseInt(input[i]);
            }
            else{
                num[i]=-100;
            }
        }*/
        if(queue.peek().matches("\\d+")){
            root=new TreeNode(Integer.parseInt(queue.poll()));
            root.left=DeSerialize(root.left,queue);
            root.right=DeSerialize(root.right,queue);
        }
        else{
            queue.poll();
        }
        return root;
    }
    public static void main(String[] args) {
        /*Scanner sc=new Scanner(System.in);
        sc.useDelimiter("\n");
        String input[]=sc.nextLine().toString().split(" ");
        int num[]=new int[input.length];
        for(int i=0;i<num.length;i++){
            num[i]=Integer.parseInt(input[i]);
        }
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }*/
        int array[]={10,6,14,4,8,12,16};
        treeOper op=new treeOper();
        TreeNode root=op.createTree(array);
        SerializeTree37 test=new SerializeTree37();
        test.Serialize(root);
        System.out.println();
        SerializeTree37 test2=new SerializeTree37();
        Scanner sc=new Scanner(System.in);
        sc.useDelimiter("\n");
        String input[]=sc.nextLine().toString().split(" ");
        Queue<String> queue=new LinkedList<>();
        for(int i=0;i<input.length;i++){
            queue.add(input[i]);
        }
        TreeNode root2=null;
        root2=test2.DeSerialize(root2,queue);
        op.printTree(root2);
    }
}
