package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlatternBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        recursive(root);
    }

    private TreeNode[] recursive(TreeNode node){
        TreeNode[] nodes = new TreeNode[2];
        if(node.left == null && node.right == null){
            nodes[0] = node;
            nodes[1] = node;
        } else if(node.left != null && node.right == null) {
            TreeNode[] lefts = recursive(node.left);
            node.left = null;
            node.right = lefts[0];
            nodes[0] = node;
            nodes[1] = lefts[1];
        } else if(node.left == null && node.right != null){
            TreeNode[] rights = recursive(node.right);
            nodes[0] = node;
            nodes[1] = rights[1];
        } else {
            TreeNode[] lefts = recursive(node.left);
            TreeNode[] rights = recursive(node.right);
            node.left = null;
            node.right = lefts[0];
            lefts[1].right = rights[0];
            nodes[0] = node;
            nodes[1] = rights[1];
        }
        return nodes;
    }
}
