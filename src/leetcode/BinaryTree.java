package leetcode;

import java.util.Scanner;
/**
 * Created by Administrator on 2017/8/31.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode getLeftChild() {
        return left;
    }
    public void setLeftChild(TreeNode leftChild) {
        this.left = leftChild;
    }
    public TreeNode getRightChild() {
        return right;
    }
    public void setRightChild(TreeNode rightChild) {
        this.right = rightChild;
    }
    public int getData() {
        return val;
    }
    public void setData(int data) {
        this.val = data;
    }
}
public class BinaryTree {
    public static void main(String args[]) {
        int pre[]={1,2,4,7,3,5,6,8};
        int in[]={4,7,2,1,5,3,8,6};
        TreeNode root=new BinaryTree().ConstructTree(pre,0,pre.length-1,in,0,in.length-1);
        System.out.print("中序遍历");
        inOrder(root);
        System.out.println();
        System.out.print("前序遍历");
        preOrder(root);
        System.out.println();
        System.out.print("后序遍历");
        postOrder(root);
        System.out.println();
        System.out.println(maxDepth(root));
    }

    public TreeNode ConstructTree(int pre[],int startpre,int endPre,int in[],int startin,int endin){
        TreeNode root=new TreeNode(pre[startpre]);
        if(startpre==endPre){
            if(startin==endin&&pre[startpre]==in[startin])
                return root;
            else{
                return null;
            }
        }
        int rootin=startin;
        while(rootin<=endin&&in[rootin]!=root.val)
            ++rootin;
        int leftlength=rootin-startin;
        int leftpreend=startpre+leftlength;
        if(leftlength>0){
            root.left=ConstructTree(pre,startpre+1,leftpreend,in,startin,rootin-1);
        }
        if(leftlength<endPre-startpre){
            root.right=ConstructTree(pre,leftpreend+1,endPre,in,rootin+1,endin);
        }
        return root;
/*
        for(int i=startin;i<endin;i++){
            if(in[i]==pre[startpre]){
                root.left=ConstructTree(pre,startpre+1,startpre+i,in,startin,i-1);
                root.right=ConstructTree(pre,startpre+i+1,endPre,in,i+1,endin);
            }
        }
        return root;
*/
    }
    /**
     * 中序遍历
     * @param node
     */
    private static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.print(node.getData()+" ");
            inOrder(node.getRightChild());
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    private static void preOrder(TreeNode node) {
        if(node != null) {
            System.out.print(node.getData()+" ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
    /**
     * 后序遍历
     * @param node
     */
    private static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.print(node.getData()+" ");
        }
    }

    private static int maxDepth(TreeNode root) {
        // write your code (here)
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }
}
