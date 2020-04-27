package com.moses.leet.n0100;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dL = new ListNode(0);
        ListNode lCur = dL;
        ListNode dR = new ListNode(0);
        ListNode rCur = dR;
        while(head != null){
            if(head.val < x){
                lCur.next = head;
                lCur = lCur.next;
            }else{
                rCur.next = head;
                rCur = rCur.next;
            }
            head = head.next;
        }
        rCur.next = null;
        lCur.next = dR.next;
        return dL.next;
    }

    public ListNode partitionOld(ListNode head, int x) {
        ListNode slow = null;
        ListNode fast = head;
        ListNode fast_1 = null;

        ListNode newHead = null;

        if(head == null || head.next == null){
            return head;
        }

        //head.next
        if(head.val < x){
            slow = head;
            newHead = head;
            while(head.next != null && head.next.val < x){  //head becomes first node which is >= x
                slow = head.next;
                head = head.next;
            }
            head = head.next;
            fast_1 = slow;
            fast = slow.next;
        } else {
            fast_1 = fast;
            fast = fast.next;
        }

        if(fast == null){
            if(newHead == null){
                newHead = head;
            }
            return newHead;
        }

        while(fast.next != null){
            ListNode tmpNext = fast.next;
            if(fast.val < x){
                if(slow == null){
                    slow = fast;
                    slow.next = head;
                    newHead = slow;
                } else {
                    slow.next = fast;
                    slow = slow.next;
                    slow.next = head;
                }
            } else {
                fast_1.next = fast;
                fast_1 = fast_1.next;
            }
            fast = tmpNext;
        }

        //last node
        if(fast.val < x){
            if(slow == null){
                slow = fast;
                slow.next = head;
                newHead = slow;
            } else {
                slow.next = fast;
                slow = slow.next;
                slow.next = head;
            }
            fast_1.next = null;
        }else {
            fast_1.next = fast;

        }

        if(newHead == null){
            newHead = head;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromIntegers(1,4,3,2,5,2);
        int x = 3;
        PrintUtil.traverseNodes(new PartitionList().partition(head, x));

        head = ListNodeUtil.fromIntegers(1,1);
        x = 0;
        PrintUtil.traverseNodes(new PartitionList().partition(head, x));

        head = ListNodeUtil.fromIntegers(1,2,3,4,5,2);
        x = 3;
        PrintUtil.traverseNodes(new PartitionList().partition(head, x));

        head = ListNodeUtil.fromIntegers(6,5,3,4,5,2);
        x = 3;
        PrintUtil.traverseNodes(new PartitionList().partition(head, x));

        head = ListNodeUtil.fromIntegers(6,5,1,4,5,2);
        x = 3;
        PrintUtil.traverseNodes(new PartitionList().partition(head, x));

        head = ListNodeUtil.fromIntegers(6,5,3,2,1,4,5,7);  // 2,6,5,3,1,4,5,7; 2,1,6,5,3,4,5,7
        x = 3;
        PrintUtil.traverseNodes(new PartitionList().partition(head, x));

        head = ListNodeUtil.fromIntegers(2,1,1,2,2);
        x = 3;
        PrintUtil.traverseNodes(new PartitionList().partition(head, x));

        head = ListNodeUtil.fromIntegers(3,2,1,1,2,2);
        x = 3;
        PrintUtil.traverseNodes(new PartitionList().partition(head, x));
    }
}
