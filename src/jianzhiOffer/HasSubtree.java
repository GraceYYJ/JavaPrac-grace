package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/11/27.
 */
public class HasSubtree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val)
                result=HasSubTreeNode(root1,root2);
            //如果结果为false，说明之前找到的根节点不对
            if(!result)
                result=HasSubtree(root1.left,root2);
            if(!result)
                result=HasSubtree(root1.right,root2);
        }
        return result;
    }

    public boolean HasSubTreeNode(TreeNode root1,TreeNode root2){
        if(root2==null)
            return true;
        //B还未到最后的节点，A已走完
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return HasSubTreeNode(root1.left,root2.left)&&HasSubTreeNode(root1.right,root2.right);
    }

    public static void printTree(TreeNode tree){
        Queue queue = new LinkedList();
        TreeNode last = null;
        TreeNode nlast = null;
        TreeNode tmpNode = null;
        queue.add(tree);
        last = tree;
        while(!queue.isEmpty()){
            tmpNode = (TreeNode)queue.poll();
            if(null != tmpNode.left){
                queue.add(tmpNode.left);
                nlast = tmpNode.left;
            }

            if(null != tmpNode.right){
                queue.add(tmpNode.right);
                nlast = tmpNode.right;
            }
            System.out.print(tmpNode.val);
            if(tmpNode.equals(last)){
                System.out.print("\n");
                last = nlast;
            }else{
                continue;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(8);
        TreeNode second=new TreeNode(8);
        TreeNode third=new TreeNode(7);
        TreeNode fourth=new TreeNode(9);
        TreeNode fifth=new TreeNode(2);
        TreeNode sixth=new TreeNode(4);
        TreeNode seventh=new TreeNode(7);
        root1.left=second;
        root1.right=third;
        second.left=fourth;
        second.right=fifth;
        fifth.left=sixth;
        fifth.right=seventh;

        TreeNode root2=new TreeNode(8);
        TreeNode second2=new TreeNode(9);
        TreeNode third2=new TreeNode(2);
        root2.left=second2;
        root2.right=third2;

        HasSubtree test=new HasSubtree();
        System.out.print(test.HasSubtree(root1,null));
    }
}
