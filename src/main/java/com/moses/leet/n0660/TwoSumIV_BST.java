package com.moses.leet.n0660;

import com.moses.leet.pojo.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV_BST {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }



    public boolean findTarget1(TreeNode root, int k) {
        return findEach(root, k, root);
    }

    private boolean findEach(TreeNode node, int k, TreeNode root) {
        if(node == null){
            return false;
        }
        int remain = k-node.val;
        if(remain != node.val && search(root, remain)){
            return true;
        }else{
            return findEach(node.left, k, root) || findEach(node.right, k, root);
        }
    }

    private boolean search(TreeNode root, int remain) {
        if(root == null){
            return false;
        }
        if(remain==root.val){
            return true;
        }else if(remain < root.val){
            return search(root.left, remain);
        }else{
            return search(root.right, remain);
        }
    }
}
