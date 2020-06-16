package com.moses.leet.n0300;

import com.moses.leet.pojo.TreeNode;

import java.util.Stack;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 */
public class InorderSuccessorInBST {


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p==null){
            return res;
        }
        if(root.val > p.val){
            res = root;
            return inorderSuccessor(root.left, p);
        }else if(root.val < p.val){
            return inorderSuccessor(root.right, p);
        }else{
            if(root.right == null){
                return res;
            }else{
                root = root.right;
                while(root.left != null){
                    root = root.left;
                }
                return root;
            }
        }
    }


    TreeNode res = null;
    public TreeNode inorderSuccessorIn(TreeNode root, TreeNode p) {
        inorder(root, p);
        return res;
    }

    void inorder(TreeNode root, TreeNode p){
        if(root == null || p == null){
            return;
        }
        inorder(root.left, p);
        if(res == null && root.val > p.val){
            res = root;
            return;
        }
        inorder(root.right, p);
    }

    public TreeNode inorderSuccessorStack(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right != null){
                TreeNode tmp = cur.right;
                stack.push(tmp);
                while(tmp.left != null){
                    tmp = tmp.left;
                    stack.push(tmp);
                }
            }
            if(cur == p){
                return stack.isEmpty()?null:stack.pop();
            }
        }
        return null;
    }
}
