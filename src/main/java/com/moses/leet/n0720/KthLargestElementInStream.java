package com.moses.leet.n0720;

import java.util.*;

public class KthLargestElementInStream {
    class KthLargest {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int size;
        public KthLargest(int k, int[] nums) {
            this.size = k;
            for(int i=0; i<nums.length; i++){
                p.offer(nums[i]);
                if(p.size()>k){
                    p.poll();
                }
            }
        }

        public int add(int val) {
            if(p.size() == size && val <= p.peek()){
                return p.peek();
            }
            p.offer(val);
            if(p.size()>size){
                p.poll();
            }
            return p.peek();
        }

    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0};
        KthLargest kth = new KthLargestElementInStream().new KthLargest(2, nums);
        System.out.println(kth.add(-1));
        System.out.println(kth.add(1));
        System.out.println(kth.add(-2));
        System.out.println(kth.add(-4));
        System.out.println(kth.add(3));

    }
}
