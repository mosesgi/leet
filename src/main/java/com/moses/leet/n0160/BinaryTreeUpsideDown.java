package com.moses.leet.n0160;

import com.moses.leet.pojo.TreeNode;

import java.util.Stack;

public class BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
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
