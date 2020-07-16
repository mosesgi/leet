package com.moses.leet.n1380;

import com.moses.leet.pojo.TreeNode;

public class LongestZigzagPathInBinaryTree {
    int res = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return res - 1;
    }

    int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int l = left[1] + 1;
        int r = right[0] + 1;
        res = Math.max(res, Math.max(l, r));
        return new int[]{l, r};
    }
}
