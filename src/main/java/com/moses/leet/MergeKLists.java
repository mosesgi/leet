package com.moses.leet;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists){
        ListNode resultHead = new ListNode(0);
        ListNode resultCurr = resultHead;

        while(true){
            List<Integer> ints = new ArrayList<>();
            boolean shouldBreak = true;

            for(int i=0; i<lists.length; i++){
                if(lists[i] != null){
                    ints.add(lists[i].val);
                    shouldBreak = false;
                }
            }

            if(shouldBreak){
                break;
            }

            Collections.sort(ints);     //工具类排序比自己一个个比较要快...

            for(int i=0; i<lists.length; i++) {
                if (lists[i] != null && lists[i].val == ints.get(0)) {
                    resultCurr.next = new ListNode(lists[i].val);
                    resultCurr = resultCurr.next;
                    lists[i] = lists[i].next;
                }
            }

        }

        return resultHead.next;
    }


    public ListNode mergeKListsApp2(ListNode[] lists){
        ListNode resultHead = new ListNode(0);
        ListNode resultCurr = resultHead;

        while(true){
            boolean shouldBreak = true;
            int minVal = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i=0; i<lists.length; i++) {
                if (lists[i] != null) {
                    if(lists[i].val <minVal) {
                        minVal = lists[i].val;
                        minIndex = i;
                    }
                    shouldBreak = false;
                }
            }

            if(shouldBreak){
                break;
            }

            resultCurr.next = new ListNode(lists[minIndex].val);
            resultCurr = resultCurr.next;
            lists[minIndex] = lists[minIndex].next;
        }

        return resultHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtil.fromIntegers(1, 4, 5);
        ListNode l2 = ListNodeUtil.fromIntegers(1, 3, 4);
        ListNode l3 = ListNodeUtil.fromIntegers(2, 6);

        PrintUtil.traverseNodes(new MergeKLists().mergeKLists(new ListNode[]{l1, l2, l3}));
    }
}
