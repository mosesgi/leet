package com.moses.leet.n0160;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        while(root != null){
            help.add(root.val);
            if(root.left != null){
                stack.push(root.left);
            }
            root = root.right;
        }
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            while(cur != null){
                help.add(cur.val);
                if(cur.left != null){
                    stack.push(cur.left);
                }
                cur = cur.right;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!help.isEmpty()){
            list.add(help.pop());
        }
        return list;
    }


    public List<Integer> postorderTraversalDfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        recursive(root, list);
        return list;
    }

    private void recursive(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        recursive(node.left, list);
        recursive(node.right, list);
        list.add(node.val);
    }


}
