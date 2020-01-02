package com.moses.leet.utils;

import com.moses.leet.pojo.ListNode;

public class ListNodeUtil {

    public static ListNode fromIntegers(int... x){
        ListNode head = new ListNode(x[0]);
        ListNode curr = head;
        for(int i = 1; i<x.length; i++){
            curr.next = new ListNode(x[i]);
            curr = curr.next;
        }
        return head;
    }
}
