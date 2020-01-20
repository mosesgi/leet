package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return recursive(root);
    }

    private int recursive(TreeNode root) {
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null && root.right != null){
            return recursive(root.right) + 1;
        } else if(root.left != null && root.right == null){
            return recursive(root.left) + 1;
        } else{
            return Math.min(recursive(root.left), recursive(root.right)) + 1;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.left.right = new TreeNode(11);
//        root.left.right.right = new TreeNode(11);
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));


    }
}
