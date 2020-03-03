package com.moses.leet.n0400;

import com.moses.leet.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
    class Solution {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int i = r.nextInt(list.size());
            return list.get(i);
        }
    }

    //https://leetcode.com/problems/linked-list-random-node/discuss/85662/Java-Solution-with-cases-explain
    //O(N) to get random element for unlimited stream
    class SolutionReservoirSampling{
        ListNode head;
        Random r;
        public SolutionReservoirSampling(ListNode head){
            this.head = head;
            r = new Random();
        }

        public int getRandom(){
            ListNode c = head;
            int rst = head.val;
            for(int i=0; c.next != null; i++){
                if(r.nextInt(i+1) == i){
                    rst = c.val;
                }
                c = c.next;
            }
            return rst;
        }
    }


}
