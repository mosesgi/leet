package com.moses.leet.n0240;

import com.moses.leet.pojo.ListNode;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode1(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = curr.next;
        while(next != null){
            curr.val = next.val;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        prev.next = null;
    }


}
