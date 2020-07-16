package com.moses.leet.lcci;

import com.moses.leet.pojo.TreeNode;

//https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
public class CheckIfTreeBalanced {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == -1 || right == -1 || Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
