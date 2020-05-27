package com.moses.leet.n1040;

import com.moses.leet.pojo.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return diff;
    }

    void dfs(TreeNode root, int min, int max){
        if(root == null){
            return;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff = Math.max(diff, Math.max(Math.abs(root.val - max), Math.abs(root.val - min)));
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
