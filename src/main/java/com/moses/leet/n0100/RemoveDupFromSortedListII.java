package com.moses.leet.n0100;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDupFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode dup1 = head;
        ListNode prev = null;
        int prev2Cnt = -2;
        boolean inDup = false;

        boolean headValid = false;
        while(curr.next != null) {
            ListNode next = head.next;

            if(head.val == next.val){
                curr = curr.next;
                continue;
            }
            if(curr.val == next.val){
                dup1 = curr;
                curr = curr.next;
                continue;
            }
            if(dup1.val == next.val){

            }
            if(!headValid){
                head = curr;
                headValid = true;
                prev = head;
            }


            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromIntegers(1,2,3,3,4,4,5);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,1,2,3);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,1,2,2,3,3,4,5,6,6,6,7);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,1,2,3,4,4,4,5,6,6,6,7,7,8,9,10,10,10,11,11,11,11,11);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,2,3,4,4,4,5,6,6,6,7,7,8,9,10,10,10,11,11,11,11,11,12,13,13,13,13,13,14,15,16,16,16,16);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));
    }
}
