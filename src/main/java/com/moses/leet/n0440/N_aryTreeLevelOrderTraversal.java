package com.moses.leet.n0440;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> allList = new ArrayList<>();
        if(root == null){
            return allList;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> levelList = new ArrayList<>();
        while(!q.isEmpty()){
            Node n = q.poll();
            if(n == null){
                allList.add(new ArrayList<>(levelList));
                levelList.clear();
                if(q.isEmpty()){
                    break;
                }
                q.offer(null);
                continue;
            }
            levelList.add(n.val);
            if(n.children != null) {
                for (Node node : n.children) {
                    q.offer(node);
                }
            }
        }
        return allList;
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
