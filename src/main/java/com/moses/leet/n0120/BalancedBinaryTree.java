package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;
import sun.reflect.generics.tree.Tree;

public class BalancedBinaryTree {
    static int BREAK_FLAG = -100;
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        return recursive(root) != BREAK_FLAG;
    }

    public int recursive(TreeNode root){
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = 0;
        if(root.left != null) {
            left = recursive(root.left);
        }
        int right = 0;
        if(root.right != null){
            right = recursive(root.right);
        }
        if(left == BREAK_FLAG || right == BREAK_FLAG || Math.abs(right-left) > 1){
            return BREAK_FLAG;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BalancedBinaryTree().isBalanced(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(new BalancedBinaryTree().isBalanced(root));

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }
}
