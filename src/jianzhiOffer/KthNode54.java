package jianzhiOffer;

import dataStructure.Tree.TreeNode;
import dataStructure.Tree.treeOper;

import java.util.Stack;

/**
 * Created by GraceYang on 2018/1/13.
 */
public class KthNode54 {
    int count=1;
    int kthval=-1;
    public int getKthNode1(TreeNode root,int k){
        if(root==null)  return kthval;
        if(root!=null){
            getKthNode1(root.left,k);
            if(count==k)
                kthval=root.val;
            count++;
            getKthNode1(root.right,k);
        }
        return kthval;
    }

    public int getKthNode2(TreeNode root,int k){
        if(root==null)  return kthval;
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.empty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(!stack.empty()){
                root=stack.pop();
                if(count==k)
                    kthval=root.val;
                count++;
                root=root.right;
            }
        }
        return kthval;
    }

    public static void main(String[] args) {
        treeOper op=new treeOper();
        int array[]={5,3,7,2,4,6,8};
        TreeNode root=op.createTree(array);
        System.out.println(new KthNode54().getKthNode2(root,0));
    }
}
