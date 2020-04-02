package com.moses.leet.n0680;

import com.moses.leet.pojo.TreeNode;

public class SecondMinimumNodeInBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null){
            return -1;
        }

        int left = root.val == root.left.val ? findSecondMinimumValue(root.left) : root.left.val;
        int right = root.val == root.right.val ? findSecondMinimumValue(root.right) : root.right.val;
        if(left== -1 && right == -1){
            return -1;
        }else if(left == -1){
            return right;
        }else if(right == -1){
            return left;
        }else{
            return Math.min(left, right);
        }
    }

}
