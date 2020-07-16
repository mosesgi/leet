package com.moses.leet.n1320;

import com.moses.leet.pojo.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {
    int res = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return res;
    }

    void dfs(TreeNode cur, TreeNode p, TreeNode grandP){
        if(cur == null){
            return;
        }
        if(grandP != null && grandP.val%2==0){
            res+=cur.val;
        }
        dfs(cur.left, cur, p);
        dfs(cur.right, cur, p);
    }
}
