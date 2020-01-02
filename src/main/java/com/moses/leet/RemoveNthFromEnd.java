package com.moses.leet;

import com.moses.leet.pojo.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode after = null;
        ListNode currNode = head;
        int curr = 1;

        while(currNode!= null){
            if(curr==n-1){
                after = head;
            }
            if(curr==n+1){
                prev = head;
            }
            if(currNode.next == null){
                if(n==1 && curr == 1){
                    return null;
                }
                if(prev != null) {
                    prev.next = after;
                } else if(curr == n){
                    head = after;
                }
                return head;
            }
            currNode = currNode.next;
            if(after != null){
                after = after.next;
            }
            if(prev != null){
                prev = prev.next;
            }
            curr++;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd rfe = new RemoveNthFromEnd();
        ListNode l1 = new ListNode(1);
        ListNode curr1 = l1;
        curr1.next = new ListNode(2);
        curr1 = curr1.next;
        curr1.next = new ListNode(3);
        curr1 = curr1.next;
        curr1.next = new ListNode(4);
        curr1 = curr1.next;
        curr1.next = new ListNode(5);

        rfe.removeNthFromEnd(l1, 2);
        while(l1 != null){
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
    }
}

