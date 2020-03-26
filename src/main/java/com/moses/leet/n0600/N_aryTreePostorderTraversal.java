package com.moses.leet.n0600;

import java.util.*;

public class N_aryTreePostorderTraversal {

    public List<Integer> postorderIterative(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> pushed = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node p = stack.peek();
            if(pushed.contains(p)){
                list.add(stack.pop().val);
                continue;
            }
            if(p.children.isEmpty()){
                list.add(stack.pop().val);
                continue;
            }
            for(int i=p.children.size()-1; i>=0; i--){
                stack.push(p.children.get(i));
            }
            pushed.add(p);
        }
        return list;
    }



    List<Integer> list = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return list;
        }
        for(Node n : root.children){
            postorder(n);
        }
        list.add(root.val);
        return list;
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
