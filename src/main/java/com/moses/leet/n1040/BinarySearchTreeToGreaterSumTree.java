package com.moses.leet.n1040;

import com.moses.leet.pojo.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

    int prev = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.right);
        root.val += prev;
        prev = root.val;
        dfs(root.left);
    }
}
