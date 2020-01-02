package com.moses.leet.utils;

import com.moses.leet.pojo.ListNode;

public class PrintUtil {
    public static void traverseNodes(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
