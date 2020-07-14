package com.moses.leet.n1380;

import com.moses.leet.pojo.TreeNode;

public class MaximumSumBSTInBinaryTree {
    int max = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }

    // valid(0,1); min; max; sum.
    int[] dfs(TreeNode root){
        if(root.left == null && root.right == null){
            max = Math.max(max, root.val);
            return new int[]{1, root.val, root.val, root.val};
        }else if(root.left == null){
            int[] right = dfs(root.right);
            if(right[0] == 0 || root.val >= right[1]){
                return new int[]{0, 0, 0, 0};
            }
            max = Math.max(max, right[3] + root.val);
            return new int[]{1, root.val, right[2], right[3]+root.val};
        }else if(root.right == null){
            int[] left = dfs(root.left);
            if(left[0] == 0 || root.val <= left[2]){
                return new int[]{0,0,0,0};
            }
            max = Math.max(max, left[3] + root.val);
            return new int[]{1, left[0], root.val, left[3] + root.val};
        }else{
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            if(left[0] == 0 || right[0] == 0 || root.val <= left[2] || root.val >=right[1]){
                return new int[]{0,0,0,0};
            }
            max = Math.max(max, left[3] + right[3] + root.val);
            return new int[]{1, left[1], right[2], left[3] + right[3] + root.val};
        }
    }
}
