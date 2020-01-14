package com.moses.leet.utils;

import com.moses.leet.pojo.ListNode;

import java.util.Arrays;

public class PrintUtil {
    public static void traverseNodes(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix){
        for(int[] i:matrix){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }
}
