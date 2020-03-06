package com.moses.leet.n0420;

import com.moses.leet.pojo.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = recursive(root.left, true);
        int right = recursive(root.right, false);
        return left+right;
    }

    private int recursive(TreeNode root, boolean isLeft) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return isLeft?root.val:0;
        }
        int left = recursive(root.left, true);
        int right = recursive(root.right, false);
        return left+right;
    }

    public static void main(String[] args) {
        TreeNode t;
        t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(t));

        t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(t));
    }
}
