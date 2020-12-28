package com.moses.leet.n0160;

import com.moses.leet.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    //from a to b, from b to a
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iterA = headA;
        ListNode iterB = headB;
        while(true){
            //if both null, they have no itersection.
            if(iterA == iterB){
                return iterA;
            }
            if(iterA == null){
                iterA = headB;
            } else {
                iterA = iterA.next;
            }
            if(iterB == null){
                iterB = headA;
            } else {
                iterB = iterB.next;
            }
        }
    }

    //count numbers and sync the step
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        ListNode currA = headA;
        ListNode currB = headB;
        while(currA != null){
            lenA++;
            currA = currA.next;
        }

        while(currB != null){
            lenB++;
            currB = currB.next;
        }

        if(lenA < lenB){
            int dif = lenB - lenA;
            for(int i=0; i<dif; i++){
                headB = headB.next;
            }
        }else if(lenA > lenB){
            int dif = lenA - lenB;
            for(int i=0; i<dif; i++){
                headA = headA.next;
            }
        }
        while(headA!= null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }

    //space complexity O(N), not O(1)
    public ListNode getIntersectionNodeOn(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


}
