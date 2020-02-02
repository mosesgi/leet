package com.moses.leet.n0160;

import com.moses.leet.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = null;
        ListNode fast = head;
        int i = 0;
        while(fast != null){
            if(fast == slow){
                return true;
            }
            int r = i%2;
            if(r == 0){
                slow = slow==null?head:slow.next;
            }
            i++;
            fast = fast.next;
        }
        return false;
    }


    // space O(n)
    public boolean hasCycleSOn(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        if(head == null || head.next == null){
            return false;
        }
        visited.add(head);
        ListNode curr = head.next;
        while(curr != null){
            if (visited.contains(curr)) {
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
