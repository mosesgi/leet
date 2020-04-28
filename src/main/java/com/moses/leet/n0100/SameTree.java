package com.moses.leet.n0100;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p == null && q!=null || p!=null && q==null || p.val != q.val){
            return false;
        }else{
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }


    public boolean isSameTreeOld(TreeNode p, TreeNode q) {
        return inOrder(p, q);
    }

    private boolean inOrder(TreeNode pCur, TreeNode qCur){
        if(pCur == null && qCur == null){
            return true;
        } else if(pCur == null && qCur != null){
            return false;
        } else if(pCur != null && qCur == null){
            return false;
        }
        boolean left = inOrder(pCur.left, qCur.left);
        if(!left) return false;
        boolean curr = pCur.val == qCur.val;
        if(!curr) return false;
        boolean right = inOrder(pCur.right, qCur.right);
        if(!right) return false;
        return true;
    }

    public static void main(String[] args) {
        
    }
}
