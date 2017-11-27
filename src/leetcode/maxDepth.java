package leetcode;

class TreeN {
     int val;
     TreeN left;
     TreeN right;
     TreeN(int x) { val = x; }
}

public class maxDepth {
    int maxDepth(TreeN root) {
        // write your code (here)
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }

    public static void main(String[] args) {
        TreeN node=new TreeN(1);
    }
}
