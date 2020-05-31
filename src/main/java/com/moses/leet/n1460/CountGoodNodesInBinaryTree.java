package com.moses.leet.n1460;

import com.moses.leet.pojo.TreeNode;

public class CountGoodNodesInBinaryTree {
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    void dfs(TreeNode root, int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            res++;
        }
        max = Math.max(max, root.val);
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
