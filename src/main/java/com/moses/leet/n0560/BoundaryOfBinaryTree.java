package com.moses.leet.n0560;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.add(root.val);
        if(root.left == null && root.right == null){
            return res;
        }
        if(root.left != null){
            left(root.left, res);
            res.remove(res.size()-1);
        }
        bottom(root, res);
        if(root.right != null){
            res.remove(res.size()-1);
            Stack<Integer> stack = new Stack<>();
            right(root.right, stack);
            while(!stack.isEmpty()){
                res.add(stack.pop());
            }
        }
        return res;
    }

    void left(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        if(root.left != null){
            left(root.left, res);
        }else{
            left(root.right, res);
        }
    }

    void bottom(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        bottom(root.left, res);
        if(root.left == null && root.right == null ){
            res.add(root.val);
        }
        bottom(root.right, res);
    }


    void right(TreeNode root, Stack<Integer> stack){
        if(root == null){
            return;
        }
        stack.push(root.val);
        if(root.right != null){
            right(root.right, stack);
        }else{
            right(root.left, stack);
        }
    }
}
