package com.moses.leet.n0120;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulateNextRightPointersEachNode {
    public Node connect(Node root) {
        Node curr = root;
        Node mostLeft = root;
        Node nextLevel = null;
        while(curr != null && curr.left != null){
            if(nextLevel == null){
                mostLeft = curr;
                nextLevel = curr.left;
            } else {
                nextLevel.next = curr.left;
                nextLevel = curr.left;
            }
            nextLevel.next = curr.right;
            nextLevel = curr.right;
            curr = curr.next;
            if(curr == null){
                nextLevel.next = null;
                nextLevel = null;
                curr = mostLeft.left;
            }
        }
        return root;
    }


    // This is NOT constant space
    public Node connectCheat(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        Node prev = null;
        while(!q.isEmpty()) {
            Node n = q.poll();

            if (prev != null) {
                prev.next = n;
            }
            if (n != null) {
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            } else {
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }

            prev = n;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        PopulateNextRightPointersEachNode outer = new PopulateNextRightPointersEachNode();
        Node root = outer.new Node(1);
        root.left = outer.new Node(2);
        root.left.left = outer.new Node(4);
        root.left.right = outer.new Node(5);
        root.right = outer.new Node(3);
        root.right.left = outer.new Node(6);
        root.right.right = outer.new Node(7);
        outer.connect(root);
    }
}


