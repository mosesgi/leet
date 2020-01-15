package com.moses.leet.n0100;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDupFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = head;
        ListNode curr = head;
        boolean isDup = false;
        while(curr.next != null){
            if(curr.val == curr.next.val){
                curr = curr.next;
                isDup = true;
            } else {
                prev.next = curr.next;
                prev = prev.next;
                curr = curr.next;
            }
        }
        if(isDup){
            prev.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromIntegers(1,1,2);
        PrintUtil.traverseNodes(new RemoveDupFromSortedList().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,2,3,3);
        PrintUtil.traverseNodes(new RemoveDupFromSortedList().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,2,2,2,3,4,5,5,5,5,6,6,6,7,7,8,9,10);
        PrintUtil.traverseNodes(new RemoveDupFromSortedList().deleteDuplicates(head));
    }
}
