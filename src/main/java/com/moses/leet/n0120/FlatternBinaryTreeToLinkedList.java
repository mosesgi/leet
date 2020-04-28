package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlatternBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left == null){
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while(left.right != null){
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }



    //2020-04-28. Similar approach with old one.
    public void flattenSimilar(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root);
    }

    TreeNode[] dfs(TreeNode root){
        if(root.left == null && root.right == null){
            return new TreeNode[]{root, root};
        }
        if(root.left != null){
            TreeNode[] ls = dfs(root.left);
            TreeNode r = root.right;
            root.right = ls[0];
            ls[1].right = r;
            root.left = null;
            TreeNode[] rs = dfs(root.right);
            return new TreeNode[]{root, rs[1]};
        }else{
            TreeNode[] rs = dfs(root.right);
            return new TreeNode[]{root, rs[1]};
        }

    }


    public void flattenOld(TreeNode root) {
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
