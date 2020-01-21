package com.moses.leet.n0140;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    Integer max = null;
    public int maxPathSum(TreeNode root) {
        int rst = recursive(root);
        return max==null?rst:max;
    }

    private int recursive(TreeNode curr) {
        if(curr.left == null && curr.right == null){
            if(max == null || curr.val > max){
                max = curr.val;
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

        if(max == null || left + right + curr.val > max){
            max = left+right+curr.val;
        }

        if(left+curr.val < 0 && right+curr.val <0){
            return 0;
        }
        return left<right?right+curr.val : left + curr.val;
    }

    public static void main(String[] args) {

    }
}
