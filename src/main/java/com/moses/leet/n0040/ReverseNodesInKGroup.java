package com.moses.leet.n0040;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

import java.util.Stack;

public class ReverseNodesInKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode start = head;
        ListNode prev = dummy;
        int i = 1;

        while(cur != null) {
            while (i < k  && cur.next != null) {
                cur = cur.next;
                i++;
            }
            if (i < k) {
                prev.next = start;
                return dummy.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            ListNode newHead = reverse(start);
            prev.next = newHead;

            prev = start;
            start = next;
            cur = start;
            i=1;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode cur = start;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


    public ListNode reverseKGroup1(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode end = cur;
        while(cur != null){
            boolean hasK = true;
            for(int i=0; i<k; i++){
                end = end.next;
                if(end == null){
                    hasK = false;
                    break;
                }
            }
            if(!hasK){
                return dummy.next;
            }
            ListNode next = cur.next;
            cur.next = rev(cur.next, end, end.next);
            cur = next;
            end = cur;
        }
        return dummy.next;
    }

    private ListNode rev(ListNode start, ListNode end, ListNode prev) {
        if(start==end){
            start.next = prev;
            return end;
        }
        ListNode next = start.next;
        start.next = prev;
        return rev(next, end, start);
    }

    public static void main(String[] args) {
        ListNode node = ListNodeUtil.fromIntegers(1, 2, 3, 4, 5);
        PrintUtil.traverseNodes(new ReverseNodesInKGroup().reverseKGroup(node, 2));
         node = ListNodeUtil.fromIntegers(1, 2, 3, 4, 5);
        PrintUtil.traverseNodes(new ReverseNodesInKGroup().reverseKGroup(node, 3));
    }

    public ListNode reverseKGroupOld(ListNode head, int k){
        ListNode currNode = head;
        int curr = 1;
        Stack<ListNode> stack = new Stack<>();
        ListNode prevEndNode = null;

        while(currNode != null){
            stack.push(currNode);

            if(curr%k == 0){
                ListNode nextNode = currNode.next;
                ListNode firstNode = stack.pop();
                if(curr == k){
                    head = firstNode;
                }
                if(prevEndNode != null){
                    prevEndNode.next = firstNode;
                }
                while(!stack.isEmpty()){
                    firstNode.next = stack.pop();
                    firstNode = firstNode.next;
                }
                firstNode.next = nextNode;
                currNode = firstNode;
                prevEndNode = currNode;
            }

            currNode = currNode.next;
            curr++;
        }
        return head;
    }



}
