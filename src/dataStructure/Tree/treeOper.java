package dataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Gracee on 2017/11/27.
 *
 */
public class treeOper{
    //创建二叉树：输入数组，其中-1代表null；返回根节点
    public TreeNode createTree(int[] array){
        int length=array.length;
        TreeNode tree[]=new TreeNode[length];
        int i=0;
        while(i<length){
            if(array[i]!=-1)
                tree[i]=new TreeNode(array[i]);
            i++;
        }
        int j=0;
        while(j<length){
            if(tree[j]==null){
                j++;
                continue;
            }
            if(2*j+1<length)
                tree[j].left=tree[2*j+1];
            if(2*j+2<length)
                tree[j].right=tree[2*j+2];
            j++;
        }
        return tree[0];
    }

    public void printTree2(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null) queue.add(root);
        int nextLevel=0;
        int toBePrinted=1;
        while(queue.size()!=0){
            root=queue.poll();
            toBePrinted--;
            System.out.print(root.val+" ");
            if(root.left!=null){
                queue.add(root.left);
                nextLevel++;
            }
            if(root.right!=null){
                queue.add(root.right);
                nextLevel++;
            }
            if(toBePrinted==0){
                System.out.println();
                toBePrinted=nextLevel;
                nextLevel=0;
            }
        }
    }
    //按层打印二叉树
    public void printTree(TreeNode tree) {
        Queue queue = new LinkedList();
        TreeNode last = null;
        TreeNode nlast = null;
        TreeNode tmpNode = null;
        queue.add(tree);
        last = tree;
        while (!queue.isEmpty()) {
            tmpNode = (TreeNode) queue.poll();
            if (null != tmpNode.left) {
                queue.add(tmpNode.left);
                nlast = tmpNode.left;
            }
            if (null != tmpNode.right) {
                queue.add(tmpNode.right);
                nlast = tmpNode.right;
            }
            System.out.print(tmpNode.val+" ");
            if (tmpNode.equals(last)) {
                System.out.print("\n");
                last = nlast;
            } else {
                continue;
            }
        }
    }
    //求二叉树深度
    public int depth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int l=depth(root.left);
        int r=depth(root.right);
        return l>r?l+1:r+1;
    }


    //二叉树的前序、中序、后序、层次遍历；递归+非递归方法

    //前序递归遍历
    public void preOrderRecur(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrderRecur(root.left);
            preOrderRecur(root.right);
        }
    }
    //前序非递归遍历
    public void preOrderLoop(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.empty()){
            while(root!=null){
                System.out.print(root.val+" ");
                stack.push(root);
                root=root.left;
            }
            if(!stack.empty()){
                root=stack.pop();
                root=root.right;
            }
        }

    }
    //中序递归遍历
    public void midOrderRecur(TreeNode root){
        if(root!=null){
            preOrderRecur(root.left);
            System.out.print(root.val+" ");
            preOrderRecur(root.right);
        }

    }
    //中序非递归遍历
    public void midOrderLoop(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.empty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(!stack.empty()){
                root=stack.pop();
                System.out.print(root.val+" ");
                root=root.right;
            }
        }

    }
    //后序递归遍历
    public void posOrderRecur(TreeNode root){
        if(root!=null){
            preOrderRecur(root.left);
            preOrderRecur(root.right);
            System.out.print(root.val+" ");
        }
    }
    //后序非递归遍历
    public void posOrderLoop(TreeNode root){
        Stack<TreeNode> stack1=new Stack<>();
        Stack<Boolean> stack2=new Stack<>();
        boolean visited;
        stack1.push(root);stack2.push(false);
        while(!stack1.empty()&&!stack2.empty()){
            root=stack1.pop();visited=stack2.pop();
            if(root==null)
                continue;
            if(visited==true){
                System.out.print(root.val+" ");
            }
            else {
                stack1.push(root);stack2.push(true);
                stack1.push(root.right);stack2.push(false);
                stack1.push(root.left);stack2.push(false);
            }
        }
    }
    //层次递归遍历
    public void levelOrderRecur(TreeNode root) {
        if (root==null) return;
        int depth=depth(root);
        for (int i=1;i<=depth;i++) {
            levelOrder(root, i);
        }
    }
    private void levelOrder(TreeNode root, int level) {
        if(root==null||level<1) return;
        if(level==1) {
            System.out.print(root.val+" ");
            return;
        }
        levelOrder(root.left,level-1);
        levelOrder(root.right,level-1);
    }
    //层次非递归遍历
    public void levelOrderLoop(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null) queue.add(root);
        while(queue.size()!=0){
            root= queue.poll();
            System.out.print(root.val+" ");
            if(root.left!=null) queue.add(root.left);
            if(root.right!=null) queue.add(root.right);
        }
    }

    public static void main(String[] args) {
        treeOper op=new treeOper();
        int array[]={7,6,4,-1,2,5,8,-1,-1,5};
        TreeNode root=op.createTree(array);
        System.out.println("创建的树：");
        op.printTree2(root);
        System.out.println("二叉树深度：");
        System.out.print(op.depth(root));
        System.out.println("\n前序递归遍历：");
        op.preOrderRecur(root);
        System.out.println("\n前序非递归遍历：");
        op.preOrderLoop(root);
        System.out.println("\n中序递归遍历：");
        op.midOrderRecur(root);
        System.out.println("\n中序非递归遍历：");
        op.midOrderLoop(root);
        System.out.println("\n后序递归遍历：");
        op.posOrderRecur(root);
        System.out.println("\n后序非递归遍历：");
        op.posOrderLoop(root);
        System.out.println("\n层次递归遍历：");
        op.levelOrderRecur(root);
        System.out.println("\n层次非递归遍历：");
        op.levelOrderLoop(root);
    }
}