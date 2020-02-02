package com.moses.leet.n0160;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    //use stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    private void recursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);

        recursive(root.left, list);
        recursive(root.right, list);
    }

    public static void main(String[] args) {

    }
}
