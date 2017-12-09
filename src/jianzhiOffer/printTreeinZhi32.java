package jianzhiOffer;

import dataStructure.Tree.TreeNode;
import dataStructure.Tree.treeOper;

import java.util.Stack;

/**
 * Created by Administrator on 2017/12/4.
 */
public class printTreeinZhi32 {
    public void printTreeinZhi(TreeNode root){
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        int nextLevel=0;
        int toBePrinted=1;
        int count=1;
        if(root!=null)
            stack1.push(root);
        while(!stack1.empty()||!stack2.empty()){
            while(!stack1.empty()&&count%2!=0){
                root=stack1.pop();
                System.out.print(root.val+" ");
                toBePrinted--;
                if(root.left!=null){
                    stack2.push(root.left);
                    nextLevel++;
                }
                if(root.right!=null){
                    stack2.push(root.right);
                    nextLevel++;
                }
            }
            while(!stack2.empty()&&count%2==0){
                root=stack2.pop();
                System.out.print(root.val+" ");
                toBePrinted--;
                if(root.right!=null){
                    stack1.push(root.right);
                    nextLevel++;
                }
                if(root.left!=null){
                    stack1.push(root.left);
                    nextLevel++;
                }
            }
            count++;
            if(toBePrinted==0){
                System.out.println();
                toBePrinted=nextLevel;
                nextLevel=0;
            }
        }
    }

    public static void main(String[] args) {
        treeOper op=new treeOper();
        int array[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode root=op.createTree(array);
        System.out.println("创建的树：");
        new printTreeinZhi32().printTreeinZhi(root);
    }
}
