package com.moses.leet.n0080;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }
        ListNode end = head;
        int size = 1;

        while(end.next != null){
            end = end.next;
            size++;
        }
        int realRotate = k%size;

        if(realRotate == 0){
            return head;
        }

        int cutNum = size-realRotate;
        ListNode newHead = head;
        ListNode newEnd = head;
        for(int i=1; i<=cutNum; i++){
            newHead = newHead.next;
            if(i == cutNum-1){
                newEnd = newHead;
            }
        }

        newEnd.next = null;
        end.next = head;
        head = newHead;
        return head;
    }


    public static void main(String[] args) {
        ListNode node = ListNodeUtil.fromIntegers(1,2,3,4,5);
        node = new RotateList().rotateRight(node, 2);
        PrintUtil.traverseNodes(node);

        node = ListNodeUtil.fromIntegers(0,1,2);
        node = new RotateList().rotateRight(node, 4);
        PrintUtil.traverseNodes(node);
    }
}
