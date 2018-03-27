package jianzhiOffer;

/**
 * Created by Administrator on 2018/1/31.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class TreeDepth55 {
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftdepth=TreeDepth(root.left);
        int rightdepth=TreeDepth(root.right);

        return(leftdepth>rightdepth)?(leftdepth+1):(rightdepth+1);
    }
}
