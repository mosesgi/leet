package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
    int max = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return max;
        recursive(root, 1);
        return max;
    }

    private void recursive(TreeNode node, int currLevel){
        if(node == null){
            if(currLevel-1 > max){
                max = currLevel - 1;
            }
            return;
        }
        recursive(node.left, currLevel + 1);
        recursive(node.right, currLevel + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(1);

        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));

        System.out.println(Integer.MIN_VALUE);
    }
}
