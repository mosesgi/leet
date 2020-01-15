package com.moses.leet.utils;

import com.moses.leet.pojo.ListNode;

import java.util.Arrays;
import java.util.List;

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

    public static <T> void printNestedList(List<List<T>> list) {
        for(List<T> l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();
    }
}
