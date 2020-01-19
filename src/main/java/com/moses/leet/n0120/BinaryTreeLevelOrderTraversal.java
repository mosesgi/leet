package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        q.add(null);

        List<Integer> row = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr != null){
                row.add(curr.val);
            } else {
                list.add(new ArrayList<>(row));
                row.clear();
            }

            if (curr == null) {
                if(q.isEmpty()){
                    continue;
                } else {
                    q.add(null);
                    continue;
                }
            }
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        PrintUtil.printNestedList(new BinaryTreeLevelOrderTraversal().levelOrder(root));


    }
}
