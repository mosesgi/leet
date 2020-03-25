package com.moses.leet.n0580;

import com.moses.leet.pojo.TreeNode;

public class BinaryTreeTilt {
    int total = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return total;
    }

    private int sum(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        total += Math.abs(right-left);
        return left+right+node.val;
    }
}
