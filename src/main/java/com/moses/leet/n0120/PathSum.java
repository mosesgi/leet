package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null ){
            return false;
        }
        return recursive(root, 0, sum);
    }

    private boolean recursive(TreeNode root, int tmp, int sum) {
        if(root.left == null && root.right == null){
            return (tmp + root.val) == sum;
        }
        tmp = tmp+root.val;
        if(root.left == null && root.right != null){
            return recursive(root.right, tmp, sum);
        } else if(root.left != null && root.right == null){
            return recursive(root.left, tmp, sum);
        } else {
            return recursive(root.left, tmp, sum) || recursive(root.right, tmp, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new PathSum().hasPathSum(root, 2));


    }
}
