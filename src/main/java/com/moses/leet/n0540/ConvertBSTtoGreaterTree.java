package com.moses.leet.n0540;

import com.moses.leet.pojo.TreeNode;

public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        recursive(root, 0);
        return root;
    }

    private int recursive(TreeNode root, int val) {
        if(root == null){
            return val;
        }
        int right = recursive(root.right, 0);
        int curr = root.val;
        root.val = curr + right;

        return recursive(root.left, root.val);
    }
}
