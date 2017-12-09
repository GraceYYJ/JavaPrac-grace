package jianzhiOffer;
import dataStructure.Tree.TreeNode;
import dataStructure.Tree.treeOper;

/**
 * Created by Administrator on 2017/11/29.
 */
public class isSymmetrical {
    public boolean isSymmetricaltree(TreeNode root){
        return isSymmetricaltree(root,root);
    }
    public boolean isSymmetricaltree(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return true;
        if(root1==null||root2==null) return true;
        if(root1.val!=root2.val) return false;
        return isSymmetricaltree(root1.left,root2.right)&&
                isSymmetricaltree(root1.right,root2.left);
    }

    public static void main(String[] args) {
        isSymmetrical test=new isSymmetrical();
        treeOper op=new treeOper();
        int array[]={1};
        TreeNode root=op.createTree(array);
        System.out.println(test.isSymmetricaltree(root));
    }
}
