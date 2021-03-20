package com.moses.leet.n0100;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDupFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        boolean preDup = false;
        while(fast != null){
            if(slow.val == fast.val){
                preDup = true;
            }else{
                if(!preDup){
                    cur.next = slow;
                    cur = cur.next;
                }
                preDup = false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        if(!preDup){
            cur.next = slow;
        }else{
            cur.next = null;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(fast != null){
            int cnt = 0;
            while(fast.next != null && fast.next.next != null && fast.next.next.val == fast.next.val){
                fast = fast.next;
                cnt++;
            }
            if(cnt > 0){
                if(fast.next == null || fast.next.next == null){
                    slow.next = null;
                    return dummy.next;
                }
                fast = fast.next;
            }else{
                fast = fast.next;
                slow.next = fast;
                slow = slow.next;
            }

        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null){
            if(fast.next != null && fast.next.next != null && fast.next.next.val == fast.next.val){
                ListNode start = fast.next;
                ListNode end = fast.next.next;
                while(end != null && start.val == end.val){
                    end = end.next;
                }
                slow.next = end;
                fast = slow;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicatesOld(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;

        while(curr.next != null) {
            boolean dupFound = false;
            //skip all duplicates
            while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
                dupFound = true;
            }
            if(dupFound && curr.next != null){
                curr = curr.next;
                if(prev != null){       //head initialized validly
                    prev.next = curr;   //temporarily set next to current node. It will be re-set if more duplicates found. Eventually set on line 45
                } else {
                    head = curr;        //head not initialized validly, but curr node might be last node.
                }
                continue;
            } else if(dupFound && curr.next == null){
                if(prev != null){
                    prev.next = null;   //ending by duplicates, need to cut off prev.next
                } else {
                    head = null;        //All are duplicates since prev not set yet, return null.
                }
                continue;
            }
            //Current node doesn't have duplicates, perform initialization if not yet
            if(prev == null){
                head = curr;        //move head to first valid Node.
                prev = head;        //initialize prev.
            } else {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromIntegers(1,2,3,3,4,4,5);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,2,2,3,3);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,2);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,1,2,3,4,4,4,5,6,6,6,7,7,8,9,10,10,10,11,11,11,11,11);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,2,3,4,4,4,5,6,6,6,7,7,8,9,10,10,10,11,11,11,11,11,12,13,13,13,13,13,14,15,16,16,16,16);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,1,2,3);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));

        head = ListNodeUtil.fromIntegers(1,1,1,2,2,3,3,4,5,6,6,6,7);
        PrintUtil.traverseNodes(new RemoveDupFromSortedListII().deleteDuplicates(head));
    }
}
