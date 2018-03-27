package dataStructure.Tree;

/**
 * Created by Administrator on 2018/3/12.
 */
import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        // write code here
        Queue queue=new LinkedList();
        ArrayList<Integer> tmplist=new ArrayList<>();
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        TreeNode last=root;
        TreeNode nlast=null;
        TreeNode temp=null;
        queue.add(root);
        while(!queue.isEmpty()){
            temp=(TreeNode)queue.poll();
            if(temp.left!=null){
                queue.add(temp.left);
                nlast=temp.left;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                nlast=temp.right;
            }
            tmplist.add(temp.val);
            if(temp.equals(last)){
                list.add(tmplist);
                tmplist=new ArrayList<>();
                last=nlast;
            }
        }
        int result[][]=new int[list.size()][];
        for(int i=0;i<list.size();i++){
            int x=list.get(i).size();
            result[i]=new int[x];
            for(int j=0;j<x;j++){
                int y=list.get(i).get(j);
                result[i][j]=y;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        treeOper op=new treeOper();
        int array[]={7,6,4,-1,2,5,8,-1,-1,5};
        TreeNode root=op.createTree(array);
        System.out.println("创建的树：");
        int result[][]=new TreePrinter().printTree(root);
    }
}
