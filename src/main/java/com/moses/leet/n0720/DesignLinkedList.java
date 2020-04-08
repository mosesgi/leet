package com.moses.leet.n0720;

public class DesignLinkedList {
    class MyLinkedList {
        Node dummyHead = new Node(-1);
        Node dummyTail = new Node(-1);
        int size=0;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(size == 0 || index < 0 || index >= size){
                return -1;
            }
            Node cur = dummyHead.next;
            for(int i=0; i<index; i++){
                cur = cur.next;
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node origin = dummyHead.next;
            Node n = new Node(val);
            dummyHead.next = n;
            n.prev = dummyHead;
            n.next = origin;
            origin.prev = n;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node origin = dummyTail.prev;
            Node n = new Node(val);
            dummyTail.prev = n;
            n.next = dummyTail;
            origin.next = n;
            n.prev = origin;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index < 0 || index > size){
                return;
            }
            if(index == size){
                addAtTail(val);
                return;
            }
            Node cur = dummyHead;
            for(int i=0; i<index; i++){
                cur = cur.next;
            }
            Node origin = cur.next;
            Node n = new Node(val);
            cur.next = n;
            n.prev = cur;
            n.next = origin;
            origin.prev = n;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index < 0 || index >=size){
                return;
            }
            Node node = dummyHead;
            for(int i=0; i<index; i++){
                node = node.next;
            }
            Node next = node.next.next;
            node.next = next;
            next.prev = node;
            size--;
        }

        class Node{
            int val;
            Node prev;
            Node next;

            public Node(int val){
                this.val = val;
            }
        }
    }
}
