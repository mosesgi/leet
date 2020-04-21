package com.moses.leet.n0820;

import com.moses.leet.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int i : G){
            set.add(i);
        }
        int res = 0;
        boolean tracking = false;
        while(head != null){
            if(set.contains(head.val)){
                if(!tracking){
                    tracking = true;
                }
            }else{
                if(tracking){
                    tracking = false;
                    res++;
                }
            }
            head = head.next;
        }
        if(tracking){
            res++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
