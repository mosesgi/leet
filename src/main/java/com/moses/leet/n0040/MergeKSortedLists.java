package com.moses.leet.n0040;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length-1);
    }

    ListNode sort(ListNode[] lists, int start, int end){
        if(start >= end){
            return lists[start];
        }
        int mid = start + (end-start)/2;
        ListNode l1 = sort(lists, start, mid);
        ListNode l2 = sort(lists, mid+1, end);
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return dummy.next;
    }



    public ListNode mergeKListsPq(ListNode[] lists){
        if(lists.length == 0 ){
            return null;
        }
        PriorityQueue<ListNode> p = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(ListNode n : lists){
            if(n!=null){
                p.offer(n);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!p.isEmpty()){
            ListNode n = p.poll();
            cur.next = n;
            cur = cur.next;
            if(n.next != null){
                p.offer(n.next);
            }
        }
        return dummy.next;
    }


    public ListNode mergeKLists1(ListNode[] lists){
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

        PrintUtil.traverseNodes(new MergeKSortedLists().mergeKLists(new ListNode[]{l1, l2, l3}));
    }
}
