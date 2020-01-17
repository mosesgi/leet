package com.moses.leet.n0100;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    /*
        [1,2,3,4,5,6,7]
        2
        5

        1,3,2,4,5,6,7
        1,4,3,2,5,6,7
        1,5,4,3,2,6,7
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head== null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode before = null;
        ListNode after = null;
        ListNode end_1 = null;

        int i=0;
        while(i<=n){
            if(i== m-1){
                before = curr;
            }
            if(i==m){
                end_1 = curr;
            }
            ListNode tmpNext = curr.next;
            if(i>m){
                if(i==m+1){ //switch first two
                    before.next = curr;
                    curr.next = end_1;
                }else {
                    ListNode beforePlus1 = before.next;
                    before.next = curr;
                    curr.next = beforePlus1;
                }
            }
            curr = tmpNext;
            i++;
        }

        end_1.next = curr;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromIntegers(1,2,3,4,5);
        PrintUtil.traverseNodes(new ReverseLinkedListII().reverseBetween(head, 2, 4));

        head = ListNodeUtil.fromIntegers(1);
        PrintUtil.traverseNodes(new ReverseLinkedListII().reverseBetween(head, 1, 1));

        head = ListNodeUtil.fromIntegers(1,2,3,4,5,6,7);
        PrintUtil.traverseNodes(new ReverseLinkedListII().reverseBetween(head, 1, 1));

        head = ListNodeUtil.fromIntegers(1,2,3,4,5,6,7);
        PrintUtil.traverseNodes(new ReverseLinkedListII().reverseBetween(head, 2, 5));

        head = ListNodeUtil.fromIntegers(1,2,3,4,5);
        PrintUtil.traverseNodes(new ReverseLinkedListII().reverseBetween(head, 1, 4));

        head = ListNodeUtil.fromIntegers(1,2,3,4,5);
        PrintUtil.traverseNodes(new ReverseLinkedListII().reverseBetween(head, 1, 5));
    }
}
