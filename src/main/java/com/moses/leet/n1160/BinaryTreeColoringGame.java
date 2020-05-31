package com.moses.leet.n1160;

import com.moses.leet.pojo.TreeNode;

public class BinaryTreeColoringGame {
    int res = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int tmp = dfs(root, x);
        res = Math.max(res, tmp);
        return res > n/2;
    }

    int dfs(TreeNode root, int x){
        if(root == null){
            return 0;
        }
        int l = dfs(root.left, x);
        int r = dfs(root.right, x);
        res = Math.max(res, Math.max(l, r));
        if(root.val == x){
            return 0;
        }
        int tmp = 1 + l + r;
        res = Math.max(res, tmp);
        return tmp;
    }
}
