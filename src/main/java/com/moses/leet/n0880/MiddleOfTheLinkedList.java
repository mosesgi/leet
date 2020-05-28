package com.moses.leet.n0880;

import com.moses.leet.pojo.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast= head;
        while(fast != null){
            if(fast.next == null){
                return slow;
            }else if(fast.next.next == null){
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return head;
    }
}
