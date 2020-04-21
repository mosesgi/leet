package com.moses.leet.n0820;

import com.moses.leet.pojo.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if(dfs(root)){
            return root;
        }else{
            return null;
        }
    }

    boolean dfs(TreeNode root){
        if(root == null){
            return false;
        }
        boolean left = dfs(root.left);
        if(!left){
            root.left = null;
        }
        boolean right = dfs(root.right);
        if(!right){
            root.right = null;
        }
        if(left || right || root.val == 1){
            return true;
        }else{
            return false;
        }
    }
}
