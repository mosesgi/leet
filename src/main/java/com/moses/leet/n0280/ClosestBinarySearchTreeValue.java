package com.moses.leet.n0280;

import com.moses.leet.pojo.TreeNode;

public class ClosestBinarySearchTreeValue {

    Integer res =null;
    Double diff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return res;
    }

    void dfs(TreeNode root, double target){
        if(root == null){
            return;
        }
        dfs(root.left, target);
        dfs(root.right, target);
        double d = Math.abs((double)root.val - target);
        if( d< diff){
            diff = d;
            res = root.val;
        }
    }

}
