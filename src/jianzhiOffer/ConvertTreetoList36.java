package jianzhiOffer;

import dataStructure.Tree.TreeNode;
import dataStructure.Tree.treeOper;

/**
 * Created by Administrator on 2017/12/7.
 */
public class ConvertTreetoList36 {
    TreeNode pLastNode=null;
    public TreeNode Convert(TreeNode pRootOfTree){
        //TreeNode pLastNode=null;
        ConvertNode(pRootOfTree);

        TreeNode pHeadNode=pLastNode;
        while(pHeadNode!=null&&pHeadNode.left!=null){
            pHeadNode=pHeadNode.left;
        }
        return pHeadNode;
    }
    public void ConvertNode(TreeNode pNode){
        if(pNode==null)
            return;
        TreeNode pCurrent=pNode;
        if(pCurrent.left!=null)
            ConvertNode(pCurrent.left);

        pCurrent.left=pLastNode;
        if(pLastNode!=null)
            pLastNode.right=pCurrent;
        pLastNode=pCurrent;

        if(pCurrent.right!=null)
            ConvertNode(pCurrent.right);
    }
    public void printDoubleLinkedlist(TreeNode head){
        if(head==null)
            System.out.println("null");
        TreeNode p=head;
        while(p.right!=null){
            System.out.print(p.val+"-right->");
            p=p.right;
        }
        System.out.println(p.val+"-right->null");
        while(p!=null){
            System.out.print(p.val+"-left->");
            p=p.left;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int array[]={10,6,14,4,8,12,16};
        treeOper op=new treeOper();
        TreeNode tree=op.createTree(array);
        ConvertTreetoList36 test=new ConvertTreetoList36();
        TreeNode doubleList=test.Convert(tree);
        test.printDoubleLinkedlist(doubleList);
    }
}
