package com.moses.leet.n1160;

import com.moses.leet.pojo.TreeNode;

public class BinaryTreeColoringGame {
    int leftSub = 0, rightSub = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int parent = dfs(root, x);
        return parent > n/2 || leftSub > n/2 || rightSub > n/2;
    }

    int dfs(TreeNode root, int x){
        if(root == null){
            return 0;
        }
        int l = dfs(root.left, x);
        int r = dfs(root.right, x);
        if(root.val == x){
            leftSub = l;
            rightSub = r;
            return 0;
        }
        return 1 + l + r;
    }
}
