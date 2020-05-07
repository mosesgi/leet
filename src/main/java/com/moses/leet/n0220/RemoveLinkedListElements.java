package com.moses.leet.n0220;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head;
        head = ListNodeUtil.fromIntegers(1,2,6,3,4,5,6);
        head = new RemoveLinkedListElements().removeElements(head, 6);
        PrintUtil.traverseNodes(head);

        head = ListNodeUtil.fromIntegers(1);
        head = new RemoveLinkedListElements().removeElements(head, 2);
        PrintUtil.traverseNodes(head);

        head = ListNodeUtil.fromIntegers(1);
        head = new RemoveLinkedListElements().removeElements(head, 1);
        PrintUtil.traverseNodes(head);
    }
}
