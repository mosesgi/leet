package com.moses.leet.n0160;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null){
            ListNode next = cur.next;
            prev.next = null;
            cur.next = null;

            ListNode inner = dummy;
            boolean inserted = false;
            while(!inserted){
                if(inner.next == null){
                    inner.next = cur;
                    prev = cur;
                    inserted = true;
                } else if (inner.val <= cur.val && inner.next.val > cur.val){
                    ListNode innerNext = inner.next;
                    inner.next = cur;
                    cur.next = innerNext;
                    inserted = true;
                }
                inner = inner.next;
            }
            prev.next = next;
            cur = next;
        }
        return dummy.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
        ListNode currN = head.next;
        ListNode prevN = head;
        ListNode nextN = currN.next;
        while(currN != null){
            ListNode from = head;
            ListNode to = prevN;
            boolean moved = false;
            while(true){
                ListNode tmpNext = from.next;
                if(from == head && currN.val < from.val){
                    head = currN;
                    currN.next = from;
                    moved = true;
                } else if(currN.val >= from.val && currN.val < from.next.val){
                    from.next = currN;
                    currN.next = tmpNext;
                    moved = true;
                }
                if(moved) {
                    prevN.next = nextN;
                    break;
                }
                if(from == to){
                    break;
                }
                from = tmpNext;
            }

            currN = nextN;
            if(currN != null) {
                nextN = currN.next;
            }
            if(!moved){
                prevN = prevN.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromIntegers(4,2,1,3);
        head = new InsertionSortList().insertionSortList(head);
        PrintUtil.traverseNodes(head);

        head = ListNodeUtil.fromIntegers(-1,0,3,4,5);
        head = new InsertionSortList().insertionSortList(head);
        PrintUtil.traverseNodes(head);

        head = ListNodeUtil.fromIntegers(4,19,14,5,-3,1,8,5,11,15);
        head = new InsertionSortList().insertionSortList(head);
        PrintUtil.traverseNodes(head);

    }
}
