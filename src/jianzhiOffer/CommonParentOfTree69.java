package jianzhiOffer;

import dataStructure.Tree.TreeNode;
import dataStructure.Tree.treeOper;

/**
 * Created by GraceYang on 2018/1/7.
 */
public class CommonParentOfTree69 {
    public TreeNode getCommonParent(TreeNode root,TreeNode node1,TreeNode node2){
        int val0=root.val;
        int val1=node1.val;
        int val2=node2.val;
        if((val1<val0&&val2>val0)||(val2<val0&&val1>val0))
            return root;
        if(val1<val0&&val2<val0)
            return getCommonParent(root.left,node1,node2);
        if(val1>val0&&val2>val0)
            return getCommonParent(root.right,node1,node2);
        else return null;
    }

    public static void main(String[] args) {
        treeOper op=new treeOper();
        int array[]={10,8,12,5,9,11,13};
        TreeNode root=op.createTree(array);
        TreeNode node1=root.left.right;
        TreeNode node2=root.left.left;
        CommonParentOfTree69 test=new CommonParentOfTree69();
        System.out.println(test.getCommonParent(root,node1,node2).val);
    }
}
