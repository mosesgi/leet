package com.moses.leet.n0800;

import com.moses.leet.pojo.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    Integer prev = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);

        if(prev == null){
            prev = root.val;
        }else{
            int dif = root.val - prev;
            min = Math.min(dif, min);
            prev = root.val;
        }
        dfs(root.right);
    }
}
