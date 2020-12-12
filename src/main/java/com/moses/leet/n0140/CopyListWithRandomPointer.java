package com.moses.leet.n0140;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node newIter = dummy;
        while(head != null){
            if(map.containsKey(head)){
                newIter.next = map.get(head);
                newIter = newIter.next;
            } else {
                Node node = new Node(head.val);
                newIter.next = node;
                newIter = newIter.next;
                map.put(head, node);
            }
            if(head.random != null){
                if(map.containsKey(head.random)){
                    newIter.random = map.get(head.random);
                }else{
                    Node node = new Node(head.random.val);
                    newIter.random = node;
                    map.put(head.random, node);
                }
            }
            head = head.next;
        }
        return dummy.next;
    }

    public Node copyRandomList2(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        Map<Node, Node> oldToNew = new HashMap<>();
        Node root = new Node(cur.val);
        Node nCur = root;
        oldToNew.put(cur, root);
        while(cur.next != null){
            nCur.next = new Node(cur.next.val);
            oldToNew.put(cur.next, nCur.next);
            nCur = nCur.next;
            cur=cur.next;
        }

        cur = head;
        nCur = root;
        while(cur != null){
            if(cur.random != null){
                nCur.random = oldToNew.get(cur.random);
            }
            nCur = nCur.next;
            cur = cur.next;
        }
        return root;
    }


    public Node copyRandomListOld(Node head) {
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
