package com.moses.leet.n0580;

import com.moses.leet.pojo.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        if(s.val == t.val){
            if(check(s, t)){
                return true;
            }
        }
        if(isSubtree(s.left, t)){
            return true;
        }
        if(isSubtree(s.right, t)){
            return true;
        }
        return false;
    }

    boolean check(TreeNode s, TreeNode t){
        if(s == null && t==null){
            return true;
        }else if(s == null || t==null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        if(!check(s.left, t.left)){
            return false;
        }
        if(!check(s.right, t.right)){
            return false;
        }
        return true;
    }



}
