package com.moses.leet.lcci;

import com.moses.leet.pojo.TreeNode;

//https://leetcode-cn.com/problems/check-subtree-lcci/
public class CheckSubtreeLCCI {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        StringBuilder sb1 = new StringBuilder();
        dfs(t1, sb1);

        StringBuilder sb2 = new StringBuilder();
        dfs(t2, sb2);

        return sb1.indexOf(sb2.toString())>=0;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if(node==null){
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }
}
