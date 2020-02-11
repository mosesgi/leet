package com.moses.leet.n0220;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;
        ListNode next = head.next;

        while(curr != null){
            if(curr.val == val){
                prev.next = next;
                curr = next;
                if(curr != null) {
                    next = curr.next;
                }
            } else {
                prev = curr;
                curr = next;
                if(curr != null) {
                    next = curr.next;
                }
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head;
        head = ListNodeUtil.fromIntegers(1,2,6,3,4,5,6);
        head = new RemoveLinkedListElements().removeElements(head, 6);
        PrintUtil.traverseNodes(head);

        head = ListNodeUtil.fromIntegers(1);
        head = new RemoveLinkedListElements().removeElements(head, 2);
        PrintUtil.traverseNodes(head);

        head = ListNodeUtil.fromIntegers(1);
        head = new RemoveLinkedListElements().removeElements(head, 1);
        PrintUtil.traverseNodes(head);
    }
}
