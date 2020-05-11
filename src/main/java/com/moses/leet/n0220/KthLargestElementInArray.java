package com.moses.leet.n0220;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o1-o2);
        for(int i : nums){
            p.offer(i);
            if(p.size() > k){
                p.poll();
            }
        }
        return p.poll();
    }

    public int findKthLargestOld(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
