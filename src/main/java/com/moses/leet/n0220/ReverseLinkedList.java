package com.moses.leet.n0220;

import com.moses.leet.pojo.ListNode;

public class ReverseLinkedList {
    //Recursively
    public ListNode reverseList(ListNode head) {
        ListNode newHead = recursive(null, head);
        return newHead;
    }

    private ListNode recursive(ListNode prev, ListNode curr){
        if(curr == null){
            return null;
        }
        if(curr.next == null){
            curr.next = prev;
            return curr;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return recursive(curr, next);
    }



    //Iteratively
    public ListNode reverseListIter(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            if(next == null){
                head = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return head;
    }


    public static void main(String[] args) {

    }


}
