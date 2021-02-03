package com.moses.leet.n0160;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode slowNext = slow.next;
        slow.next = null;
        slow = slowNext;

        ListNode prev = null;
        while(slow.next != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        slow.next = prev;

        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = slow;

            if(slow != null){
                ListNode slowNext1 = slow.next;
                slow.next = next;
                slow = slowNext1;
            }
            cur = next;
        }
    }

    public void reorderList1(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();  //使用LinkedList更好.
//        LinkedList<ListNode> l = new LinkedList<>();
//        l.pollFirst();
//        l.pollLast();
        int n = 1;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
            n++;
        }

        cur = head;
        for(int i=0; i<n/2-1; i++){
            cur = cur.next;
        }
        cur.next = null;

        cur = head;
        for(int i=0; i<n/2; i++){
            ListNode next = cur.next;
            cur.next = stack.pop();
            cur = cur.next;
            cur.next = next;
            cur = cur.next;
        }

    }

    public void reorderListOld(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        int total = 0;
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
            total++;
        }

        curr = head;
        int i = 1;
        ListNode originNext;
        while(true){
            originNext = curr.next;

            ListNode newNext = stack.pop();
            curr.next = newNext;
            i++;
            if(i == total){
                newNext.next = null;
                break;
            }
            newNext.next = originNext;
            i++;
            if(i == total){
                originNext.next = null;
                break;
            }
            curr = originNext;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromIntegers(1,2,3,4);
        new ReorderList().reorderList(head);
        PrintUtil.traverseNodes(head);

        head = ListNodeUtil.fromIntegers(1,2,3,4,5);
        new ReorderList().reorderList(head);
        PrintUtil.traverseNodes(head);
    }
}
