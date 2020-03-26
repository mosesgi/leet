package com.moses.leet.n0600;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            list.add(cur.val);
            if(cur.children.isEmpty()){
                continue;
            }
            for(int i=cur.children.size()-1; i>=0; i--){
                stack.push(cur.children.get(i));
            }
        }
        return list;
    }


    public List<Integer> preorderRecursive(Node root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    private void recursive(Node root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        for(Node n : root.children){
            recursive(n, list);
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
