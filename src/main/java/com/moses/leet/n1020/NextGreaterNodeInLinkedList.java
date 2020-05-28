package com.moses.leet.n1020;

import com.moses.leet.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<list.size(); i++){
            int cur = list.get(i);
            while(!stack.isEmpty() && cur > list.get(stack.peek())){
                int p = stack.pop();
                res[p] = cur;
            }
            stack.push(i);
        }
        return res;
    }
}
