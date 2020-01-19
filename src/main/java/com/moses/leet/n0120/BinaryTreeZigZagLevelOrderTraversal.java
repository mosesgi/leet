package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();

        boolean fromLeft = true;

        oddStack.add(root);
        Stack<TreeNode> currStack = oddStack;
        List<Integer> row = new ArrayList<>();
        while(!currStack.isEmpty()){

            Stack<TreeNode> nextStack = fromLeft?evenStack:oddStack;
            TreeNode currNode = currStack.pop();
            row.add(currNode.val);
            if(fromLeft){
                if(currNode.left != null) nextStack.push(currNode.left);
                if(currNode.right != null) nextStack.push(currNode.right);
            } else {
                if(currNode.right != null) nextStack.push(currNode.right);
                if(currNode.left != null) nextStack.push(currNode.left);
            }

            if(currStack.isEmpty()) {
                list.add(new ArrayList<>(row));
                row.clear();
                fromLeft = !fromLeft;
                currStack = nextStack;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        PrintUtil.printNestedList(new BinaryTreeZigZagLevelOrderTraversal().zigzagLevelOrder(root));

    }
}
