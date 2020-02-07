package com.moses.leet.n0180;

import com.moses.leet.pojo.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    public BinarySearchTreeIterator(TreeNode root) {
        TreeNode t = root;
        while(t != null){
            stack.push(t);
            t = t.left;
        }
    }

    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curr;
//    public BSTIterator(TreeNode root) {
//        TreeNode t = root;
//        while(t != null){
//            stack.push(t);
//            t = t.left;
//        }
//    }

    /** @return the next smallest number */
    public int next() {
        curr = stack.pop();
        if(curr.right != null){
            TreeNode tmp = curr.right;
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
        }

        return curr.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(20);

        BinarySearchTreeIterator iter = new BinarySearchTreeIterator(node);
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
    }
}
