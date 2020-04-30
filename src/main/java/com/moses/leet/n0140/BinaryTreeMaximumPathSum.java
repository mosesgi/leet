package com.moses.leet.n0140;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + leftMax+rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }



    Integer maxOld = null;
    public int maxPathSumOld(TreeNode root) {
        int rst = recursive(root);
        return maxOld ==null?rst: maxOld;
    }

    private int recursive(TreeNode curr) {
        if(curr.left == null && curr.right == null){
            if(maxOld == null || curr.val > maxOld){
                maxOld = curr.val;
            }
            return curr.val<0?0:curr.val;
        }
        int left = 0;
        if(curr.left != null){
            left = recursive(curr.left);
        }
        int right = 0;
        if(curr.right != null){
            right = recursive(curr.right);
        }

        if(maxOld == null || left + right + curr.val > maxOld){
            maxOld = left+right+curr.val;
        }

        if(left+curr.val < 0 && right+curr.val <0){
            return 0;
        }
        return left<right?right+curr.val : left + curr.val;
    }

    public static void main(String[] args) {

    }
}
