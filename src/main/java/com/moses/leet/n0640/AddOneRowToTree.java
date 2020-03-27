package com.moses.leet.n0640;

import com.moses.leet.pojo.TreeNode;

public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode r = new TreeNode(v);
            r.left = root;
            return r;
        }
        recursive(root, 1, v, d);
        return root;
    }

    private void recursive(TreeNode root, int level, int v, int d) {
        if(root == null){
            return;
        }
        if(level+1 == d){
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);
            newLeft.left = left;
            newRight.right = right;
            root.left = newLeft;
            root.right = newRight;
            return;
        }
        recursive(root.left, level+1, v, d);
        recursive(root.right, level+1, v, d);
    }
}
