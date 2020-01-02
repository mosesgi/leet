package com.moses.leet;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.PrintUtil;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rstHead = new ListNode(0);
        ListNode rstCurr = rstHead;
        while(l1 != null || l2 != null){
            if(l1 == null){
                rstCurr.next = new ListNode(l2.val);
                rstCurr = rstCurr.next;
                l2 = l2.next;
                continue;
            }
            if(l2 == null){
                rstCurr.next = new ListNode(l1.val);
                rstCurr = rstCurr.next;
                l1 = l1.next;
                continue;
            }
            if(l1.val <= l2.val){
                rstCurr.next = new ListNode(l1.val);
                rstCurr = rstCurr.next;
                l1 = l1.next;
            } else {
                rstCurr.next = new ListNode(l2.val);
                rstCurr = rstCurr.next;
                l2 = l2.next;
            }
        }
        return rstHead.next;
    }

    public ListNode appendVal(ListNode result, int val){
        if(result == null){
            result = new ListNode(val);
        } else {
            result.next = new ListNode(val);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode curr = l1;
        curr.next = new ListNode(2);
        curr = curr.next;
        curr.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        curr = l2;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(4);

        ListNode rst = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        PrintUtil.traverseNodes(rst);
    }
}
