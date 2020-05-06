package com.moses.leet.n0160;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/sort-list/
 * //TODO: Need review and recite!!!
 */
public class SortList {

    //Recursive way. not O(1) space exactly.
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        //1,2,3,4,5
        while(fast.next!=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightStart = slow.next;
        slow.next = null;

        ListNode left = sortList(dummy.next);
        ListNode right = sortList(rightStart);
        ListNode cur = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        while(left != null){
            cur.next = left;
            left = left.next;
            cur = cur.next;
        }
        while(right != null){
            cur.next = right;
            right = right.next;
            cur = cur.next;
        }
        return dummy.next;
    }




    public ListNode sortListBottomUp(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int cnt = 0;
        while(head != null){
            head = head.next;
            cnt++;
        }

        //Bottom-up. Only bottom up is constant space.
        //Merge sort, time O(nlgn)
        for(int step = 1; step<cnt; step+=step){
            ListNode prev = dummy;
            ListNode curr = dummy.next;

//            System.out.print(step + " before: ");
//            PrintUtil.traverseNodes(dummy.next);
            while(curr != null) {
                ListNode left = curr;
                ListNode right = findNodeAfterStep(left, step);
                curr = findNodeAfterStep(right, step);
                prev = mergeSort(left, right, prev);
            }
//            System.out.print(step + " after: ");
//            PrintUtil.traverseNodes(dummy.next);
        }
        return dummy.next;
    }

    private ListNode mergeSort(ListNode left, ListNode right, ListNode prev) {
        ListNode curr = prev;

        while(left != null && right != null){
            if(left.val < right.val){
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if(left != null){
            curr.next = left;
        } else if(right != null){
            curr.next = right;
        }
        while(curr.next != null){
            curr = curr.next;
        }
        return curr;
    }

    //Find Node after step and split this node with previous one.
    private ListNode findNodeAfterStep(ListNode node, int step) {
        if(node == null) return null;
        for(int i=1; node.next != null && i<step; i++){
            node = node.next;
        }

        //unlink node and its next
        ListNode next = node.next;
        node.next = null;
        return next;
    }

    public static void main(String[] args) {
//        ListNode head = ListNodeUtil.fromIntegers(4,2,1,3);
//        head = new SortList().sortList(head);
//        PrintUtil.traverseNodes(head);
//
//        head = ListNodeUtil.fromIntegers(-1,0,3,4,5);
//        head = new SortList().sortList(head);
//        PrintUtil.traverseNodes(head);

        ListNode head = ListNodeUtil.fromIntegers(4,19,14,5,-3,1,8,5,11,15);
        head = new SortList().sortList(head);
        PrintUtil.traverseNodes(head);
    }
}
