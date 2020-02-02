package com.moses.leet.n0140;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Integer, Node> old = new TreeMap<>();
        Map<Node, Integer> oldRev = new HashMap<>();
        Map<Integer, Node> copy = new TreeMap<>();
//        Map<Node, Integer> copyRev = new HashMap<>();
        Map<Integer, Integer> randomMap = new HashMap<>();

        Node oldCurr = head;
        int count = 0;

        Node newCurr = null;
        Node newHead = null;
        Node newPrev = null;
        while(oldCurr != null){
            old.put(count, oldCurr);
            oldRev.put(oldCurr, count);

            newCurr = new Node(oldCurr.val);
            copy.put(count, newCurr);
//            copyRev.put(newCurr, count);
            if(newHead == null){
                newHead = newCurr;
            }
            if(newPrev != null){
                newPrev.next = newCurr;
            }
            newPrev = newCurr;

            count++;
            oldCurr = oldCurr.next;
        }

        for(int i=0; i<count; i++){
            Node oldNode = old.get(i);
            if(oldNode.random != null) {
                int randomPointer = oldRev.get(oldNode.random);

                Node newNode = copy.get(i);
                newNode.random = copy.get(randomPointer);
            }
        }

        return newHead;
    }

    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
