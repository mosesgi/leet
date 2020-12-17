package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;
import sun.plugin.javascript.navig.Link;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean asc = true;
        while(!q.isEmpty()){
            LinkedList<Integer> row = new LinkedList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
                if(asc){
                    row.addLast(curr.val);
                }else{
                    row.addFirst(curr.val);
                }
            }
            asc = !asc;
            result.add(row);
        }
        return result;
    }


    public List<List<Integer>> zigzagLevelOrderOld(TreeNode root) {
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
