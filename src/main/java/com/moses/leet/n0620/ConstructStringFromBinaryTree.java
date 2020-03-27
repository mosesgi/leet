package com.moses.leet.n0620;

import com.moses.leet.pojo.TreeNode;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        if(t.left == null && t.right == null){
            return t.val +"";
        }
        return t.val + rec(t.left, true) + rec(t.right, false);
    }

    public String rec(TreeNode t, boolean isLeft){
        if(t == null){
            return isLeft?"()":"";
        }
        if(t.left == null && t.right == null){
            return "(" + t.val +")";
        }
        return "(" + t.val + rec(t.left, true) + rec(t.right, false) + ")";
    }
}
