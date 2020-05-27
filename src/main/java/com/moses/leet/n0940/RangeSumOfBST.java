package com.moses.leet.n0940;

import com.moses.leet.pojo.TreeNode;

public class RangeSumOfBST {
    int res = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return res;
    }

    void dfs(TreeNode root, int L, int R){
        if(root == null){
            return;
        }
        dfs(root.left, L, R);
        dfs(root.right, L, R);
        if(root.val >=L && root.val <=R){
            res+=root.val;
        }
    }
}
