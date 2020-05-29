package com.moses.leet.n0160;

import com.moses.leet.pojo.TreeNode;

import java.util.Stack;

public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null){
            return root;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = null;
        root.right = null;
        TreeNode newRoot = upsideDownBinaryTree(left);
        left.left = right;
        left.right = root;
        return newRoot;
    }

    public TreeNode upsideDownBinaryTreeStack(TreeNode root) {
        if(root == null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        TreeNode newRoot = stack.pop();
        TreeNode cur = newRoot;
        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            cur.left = p.right;
            cur.right = p;
            cur = p;
            p.left = null;
            p.right = null;
        }
        return newRoot;
    }

    public TreeNode upsideDownBinaryTreeOld(TreeNode root) {
        if(root == null){
            return null;
        }
        //3, 1, 5, 2, 4
        Stack<Integer> stack = new Stack<>();
        while(root != null){
            if(root.left == null){
                stack.push(root.val);
                break;
            }
            stack.push(root.right==null?null:root.right.val);
            stack.push(root.val);
            root = root.left;
        }

        TreeNode newRoot = new TreeNode(stack.pop());
        TreeNode cur = newRoot;
        while(!stack.isEmpty()){
            cur.right = new TreeNode(stack.pop());
            if(stack.isEmpty()){
                break;
            }
            Integer left = stack.pop();
            cur.left = left==null?null:new TreeNode(left);
            cur = cur.right;
        }
        return newRoot;
    }



}
