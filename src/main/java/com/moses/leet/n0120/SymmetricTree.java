package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    //Iterative
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if(l == null && r == null){
                continue;
            }
            if(l==null || r==null || l.val != r.val){
                return false;
            }
            q.offer(l.left);
            q.offer(r.right);
            q.offer(l.right);
            q.offer(r.left);
        }
        return true;
    }

    public boolean isSymmetricRec(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSym(root.left, root.right);
    }

    boolean isSym(TreeNode l, TreeNode r){
        if(l == null && r==null){
            return true;
        }else if(l==null || r==null || l.val != r.val){
            return false;
        }
        return isSym(l.left, r.right) && isSym(l.right, r.left);
    }


    public boolean isSymmetricOld(TreeNode root) {
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
