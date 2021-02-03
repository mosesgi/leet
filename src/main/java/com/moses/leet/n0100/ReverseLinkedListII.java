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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for(int i=1; i<m; i++){
            pre = pre.next;
        }

        ListNode oneBeforeEnd = pre.next;
        ListNode end = oneBeforeEnd.next;
        ListNode endAfter = end==null?null:end.next;
        for(int i=0; i<n-m; i++){
            oneBeforeEnd.next = endAfter;
            end.next = pre.next;
            pre.next = end;

            end = endAfter;
            endAfter = end==null?null:end.next;
        }
        return dummy.next;
    }

    //1,2,3,4,5
    //1,2,3,4,5;  1,3,2,4,5; 1,4,3,2,5; 1,5,4,3,2
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1; i<m; i++){
            prev = prev.next;
        }

        ListNode first = prev.next;
        ListNode second = first.next;
        ListNode third = second==null?null:second.next;
        for(int i=0; i<n-m; i++){
            second.next = prev.next;
            prev.next = second;
            first.next = third;

            second = third;
            third = second==null?null:second.next;
        }
        return dummy.next;
    }

    //NOT one pass....
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if(m==n || head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slowPrev = dummy, fast = dummy;
        for(int i=0; i<n; i++){
            fast = fast.next;
            if(i < m-1){
                slowPrev = slowPrev.next;
            }
        }

        ListNode fastNext = fast.next;
        fast.next = null;

        ListNode slow = slowPrev.next;
        ListNode cur = slow;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        slowPrev.next = fast;
        slow.next = fastNext;

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


    /*
        [1,2,3,4,5,6,7]
        2
        5

        1,3,2,4,5,6,7
        1,4,3,2,5,6,7
        1,5,4,3,2,6,7
     */
    public ListNode reverseBetweenOld(ListNode head, int m, int n) {
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


}
