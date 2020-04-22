package com.moses.leet.n0040;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            ListNode left = cur.next;
            ListNode right = cur.next.next;
            left.next = right.next;
            right.next = left;
            cur.next = right;
            cur = left;
        }
        return dummy.next;
    }


    public ListNode swapPairsOld(ListNode head){
        int curr = 1;
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode prepreNode = null;

        while(currNode != null){
            if(curr == 2){
                prevNode = head;
                head = currNode;
            }
            if(curr == 3){
                prepreNode = head;
            }
            if(curr%2 == 0){
                ListNode nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode.next = nextNode;
                if(prepreNode != null){
                    prepreNode.next = currNode;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }

            prevNode = prevNode!=null?prevNode.next:prevNode;
            currNode = currNode!=null?currNode.next:currNode;
            prepreNode = prepreNode!= null? prepreNode.next:prepreNode;
            curr++;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode n1 = ListNodeUtil.fromIntegers(1, 2, 3, 4, 5, 6);
        PrintUtil.traverseNodes(new SwapNodesInPairs().swapPairs(n1));
    }
}
