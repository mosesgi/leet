package com.moses.leet.n0220;

import com.moses.leet.pojo.ListNode;

public class ReverseLinkedList {
    //Recursive 3
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    //Recursively 1
    public ListNode reverseList1(ListNode head) {
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


    //Recursively 2
    public ListNode reverseListNew(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        return rev(null, head);
    }

    ListNode rev(ListNode a, ListNode b){
        if(b==null){
            return a;
        }
        ListNode next = b.next;
        b.next = a;
        return rev(b, next);
    }



    public ListNode reverseListIterative(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy =new ListNode(0);
        dummy.next = head;
        while(head.next != null){
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }

    //Iteratively
    public ListNode reverseListIterOld(ListNode head) {
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
