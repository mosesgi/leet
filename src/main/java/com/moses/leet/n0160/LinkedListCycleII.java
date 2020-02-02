package com.moses.leet.n0160;

import com.moses.leet.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    //Floyd algorithm
    //https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
    public ListNode detectCycle(ListNode head){
        //slow fast
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                //use another slow pointer to meet with existing slow
                //https://farm6.staticflickr.com/5758/22715587283_bdb4ba8434.jpg
                ListNode slow2 = head;
                while(slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }

    public ListNode detectCycleOn(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while(curr != null){
            if(set.contains(curr)){
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }

}
