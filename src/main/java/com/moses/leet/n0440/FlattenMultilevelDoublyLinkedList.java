package com.moses.leet.n0440;

public class FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        Node cur = head;
        rec(cur);
        return head;
    }

    Node rec(Node cur){
        Node last = null;
        while(cur != null){
            Node next = cur.next;
            last = cur;
            if(cur.child != null){
                Node child = cur.child;
                Node childLast = rec(child);
                cur.child = null;
                cur.next = child;
                child.prev = cur;
                childLast.next = next;
                if(next != null){
                    next.prev = childLast;
                }
                last = childLast;
            }

            cur = next;
        }
        return last;
    }


    public Node flatten1(Node head) {
        if(head == null){
            return head;
        }
        Node curr = head;
        while(curr.next != null){
            Node next = curr.next;
            if(curr.child != null){
                Node lastOfChild = flattenChild(curr);
                lastOfChild.next = next;
                next.prev = lastOfChild;
            }
            curr = next;
        }
        if(curr.child!=null){
            Node lastOfChild = flattenChild(curr);
            lastOfChild.next = null;
        }
        return head;
    }

    private Node flattenChild(Node parent) {
        Node child = parent.child;
        parent.child = null;
        parent.next = child;
        child.prev = parent;
        while(child.next != null){
            Node next = child.next;
            if(child.child != null){
                Node lastOfChild = flattenChild(child);
                lastOfChild.next = next;
                next.prev = lastOfChild;
            }
            child = next;
        }
        if(child.child!=null){
            Node lastOfChild = flattenChild(child);
            lastOfChild.next = null;
            child = lastOfChild;
        }
        return child;
    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
