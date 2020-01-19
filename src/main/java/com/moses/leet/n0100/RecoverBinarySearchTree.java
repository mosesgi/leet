package com.moses.leet.n0100;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {
    //https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
    //将树问题化为中序遍历问题，找到两个错误node.
    public void recoverTree(TreeNode root) {
        if(root == null ){
            return;
        }
    }


    private void swapVal(TreeNode a, TreeNode b){
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        TreeNode curr = root.left;
        curr.right = new TreeNode(2);
        new RecoverBinarySearchTree().recoverTree(root);
        PrintUtil.printTreeNodes(root);

        root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        new RecoverBinarySearchTree().recoverTree(root);
        PrintUtil.printTreeNodes(root);

    }
}
