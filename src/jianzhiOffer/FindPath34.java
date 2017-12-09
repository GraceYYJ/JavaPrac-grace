package jianzhiOffer;

import dataStructure.Tree.TreeNode;
import dataStructure.Tree.treeOper;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/5.
 */
public class FindPath34 {
    static ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
    static ArrayList<Integer> list=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        if(root==null) return arrayLists;
        int currentsum=0;
        FindPath1(root,target,list,currentsum);
        return arrayLists;
    }

    public void FindPath1(TreeNode root, int target,ArrayList<Integer> list,int currentsum){
        currentsum+=root.val;
        list.add(root.val);
        boolean isleaf=root.left==null&&root.right==null;
        if(currentsum==target&&isleaf){
            arrayLists.add(new ArrayList<Integer>(list));
        }
        if(root.left!=null) FindPath1(root.left,target,list,currentsum);
        if(root.right!=null) FindPath1(root.right,target,list,currentsum);
        list.remove(list.size()-1);
    }

    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        if(root==null) return arrayLists;
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null)
            arrayLists.add(new ArrayList<Integer>(list));
        //if(root.left!=null)
        FindPath2(root.left,target);
        //if(root.right!=null)
        FindPath2(root.right,target);
        list.remove(list.size()-1);
        return arrayLists;
    }
    public static void main(String[] args) {
        FindPath34 test=new FindPath34();
        treeOper op=new treeOper();
        int[] treearray={10,5,12,4,7};
        TreeNode root=op.createTree(treearray);
        test.FindPath2(root,22);
        for (ArrayList<Integer> a : arrayLists) {
            for (Integer b : a) {
                System.out.print(b+" ");
            }
            System.out.println();
        }

    }

}
