package com.moses.leet.n0240;

import com.moses.leet.pojo.TreeNode;

public class LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
            TreeNode tmp = p;
            p=q;
            q=tmp;
        }
        while(true){
            if(p.val <= root.val && q.val >= root.val){
                return root;
            } else if(p.val <root.val && q.val < root.val){
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
}
