package com.moses.leet.n0100;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(prev != null && root.val <= prev){
            return false;
        }
        prev = root.val;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorder(root, l);
        for(int i=1; i<l.size(); i++){
            if(l.get(i) <= l.get(i-1)){
                return false;
            }
        }
        return true;
    }

    void inorder(TreeNode root, List<Integer> l){
        if(root == null){
            return;
        }
        inorder(root.left, l);
        l.add(root.val);
        inorder(root.right, l);
    }



    public boolean isValidBSTOld(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        return validBST(root.left, null, root.val) && validBST(root.right, root.val, null);
    }

    private boolean validBST(TreeNode root, Integer min, Integer max){
        if(root == null ){
            return true;
        }
        boolean inRange = false;
        if(min != null && max != null){
            inRange = root.val >min && root.val < max;
        } else if(min == null && max != null){
            inRange = root.val < max;
        } else if(min != null && max == null){
            inRange = root.val > min;
        } else {
            inRange = true;
        }

        return  inRange && validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        TreeNode curr = root.right;
        curr.left = new TreeNode(6);
        curr.right = new TreeNode(20);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));

        root = new TreeNode(Integer.MIN_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));

    }
}
