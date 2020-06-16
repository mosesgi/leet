package com.moses.leet.n0440;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeAndDeserializeN_aryTree {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    void dfs(Node root, StringBuilder sb){
        sb.append(root.val).append(" ");
        if(root.children!= null && !root.children.isEmpty()){
            sb.append("[");
            for(Node r : root.children){
                dfs(r, sb);
            }
            sb.append("]");
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node root = null;
        int cur = 0;
        Node n = null;
        for(int i=0; i<data.length(); i++){
            if(data.charAt(i) == ' '){
                n = new Node(cur);
                cur = 0;
                if(stack.isEmpty()){
                    root = n;
                }else{
                    if(stack.peek().children == null){
                        stack.peek().children = new ArrayList<>();
                    }
                    stack.peek().children.add(n);
                }
            }else if(data.charAt(i) == '['){
                stack.push(n);
            }else if(data.charAt(i) == ']'){
                stack.pop();
            }else{
                cur = cur*10 + (data.charAt(i) - '0');
            }
        }
        return root;
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
