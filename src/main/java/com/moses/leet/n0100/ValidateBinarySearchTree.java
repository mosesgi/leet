package com.moses.leet.n0100;

import com.moses.leet.pojo.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
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
