package com.moses.leet.n0560;

import com.moses.leet.pojo.TreeNode;

public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        recursive(root);
        return max;
    }

    public int recursive(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = recursive(root.left);
        int right = recursive(root.right);
        int r = Math.max(left, right) + 1;
        max = Math.max(max, left+right+1);
        return r;
    }
}
