package com.moses.leet.n0720;

public class InsertIntoSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head;
        Node min = head, max = head;
        boolean first = true;
        while(true){
            Node next = cur.next;
            if(cur.val < min.val){
                min = cur;
            }
            if(cur.val >= max.val){
                max = cur;
            }
            if(cur == next || (insertVal >= cur.val && insertVal <= next.val) ){
                Node insertNode = new Node(insertVal);
                cur.next = insertNode;
                insertNode.next = next;
                return head;
            }else if(cur == head && !first) {
                break;
            } else {
                cur = next;
                if(first){
                    first = false;
                }
            }
        }
        Node insertNode = new Node(insertVal);
        if(min.val == max.val){
            Node next = head.next;
            head.next = insertNode;
            insertNode.next = next;
        }else{
            max.next = insertNode;
            insertNode.next = min;
        }
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
