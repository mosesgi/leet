package com.moses.leet.n0140;

import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Integer, Node> newNodes = new HashMap<>();

        Set<Integer> visited = new HashSet<>();

        Node root = new Node(node.val);
        newNodes.put(node.val, root);

        Queue<Node> q = new LinkedList<>();
        visited.add(node.val);
        q.offer(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            Node newNode;
            if(!newNodes.containsKey(n.val)){
                newNode = new Node(n.val);
                newNodes.put(n.val, newNode);
            }else {
                newNode = newNodes.get(n.val);
            }
            if(visited.contains(n.val)){
                continue;
            }
            List<Node> newNeighbours = new ArrayList<>();
            for(Node currNode : n.neighbors){
                Node newN;
                if(newNodes.containsKey(currNode.val)){
                    newN = newNodes.get(currNode.val);
                } else {
                    newN = new Node(currNode.val);
                    newNodes.put(currNode.val, newN);
                }
                newNeighbours.add(newN);
                q.offer(currNode);
            }
            newNode.neighbors = newNeighbours;
            visited.add(n.val);
        }
        return root;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
