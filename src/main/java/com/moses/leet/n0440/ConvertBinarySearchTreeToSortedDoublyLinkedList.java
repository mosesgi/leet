package com.moses.leet.n0440;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        dfs(root, list);
        Node head = list.get(0);
        for(int i=1; i<list.size(); i++){
            Node prev = list.get(i-1);
            Node cur = list.get(i);
            prev.right = cur;
            cur.left = prev;
        }
        Node last = list.get(list.size()-1);
        head.left = last;
        last.right = head;
        return head;
    }

    void dfs(Node root, List<Node> list){
        if(root == null){
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }


}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}