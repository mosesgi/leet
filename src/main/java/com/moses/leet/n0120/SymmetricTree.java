package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){return true;}
        return levelRecursive(root.left, root.right);
    }

    private boolean levelRecursive(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        } else if(left == null && right!=null){
            return false;
        } else if(left != null && right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        if(!levelRecursive(left.right, right.left)){
            return false;
        }
        if(!levelRecursive(left.left, right.right)){
            return false;
        }
        return true;
    }

}
