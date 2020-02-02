package com.moses.leet.n0160;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    public void reorderList(ListNode head) {
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
