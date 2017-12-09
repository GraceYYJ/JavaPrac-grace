package jianzhiOffer;
import dataStructure.Tree.TreeNode;
import dataStructure.Tree.treeOper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

/**
 * Created by Administrator on 2017/11/27.
 */
public class Mirrortree {
    public void MirrortreeRecur(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null) return;

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        if(root.left!=null)
            MirrortreeRecur(root.left);
        if(root.right!=null)
            MirrortreeRecur(root.right);
    }
    public void MirrorLoop1(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null) return;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        TreeNode pointer=root;
        while(pointer!=null){
            //TreeNode temp=pointer.left;
            //pointer.left=pointer.right;
            //pointer.right=temp;
            if(pointer.left!=null)  queue.offer(pointer.left);
            if(pointer.right!=null)  queue.offer(pointer.right);
            if(queue!=null){
                pointer=queue.poll();
            }
            else break;
        }
    }

    public void MirrorLoop2(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null) return;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        TreeNode pointer=root;
        while(!stack.empty()){
            pointer=stack.pop();
            if(pointer.left!=null||pointer.right!=null){
                TreeNode temp=pointer.left;
                pointer.left=pointer.right;
                pointer.right=temp;
            }
            if(pointer.left!=null)
                stack.push(pointer.left);
            if(pointer.right!=null)
                stack.push(pointer.right);
        }
    }

    public static void main(String[] args) {
        Mirrortree test=new Mirrortree();
        treeOper op=new treeOper();
        //TreeNode root1=op.createTree();
        //op.printTree(root1);
        //test.MirrortreeRecur(root1);
        //test.MirrorLoop1(root1);
        //test.MirrorLoop2(root1);
        //op.printTree(root1);
    }
}
