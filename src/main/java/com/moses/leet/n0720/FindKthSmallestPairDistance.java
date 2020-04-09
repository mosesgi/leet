package com.moses.leet.n0720;

import java.util.PriorityQueue;

public class FindKthSmallestPairDistance {


    public int smallestDistancePairMemoryLimitExceed(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                p.offer(Math.abs(nums[j]-nums[i]));
                if(p.size()>k){
                    p.poll();
                }
            }
        }
        return p.poll();
    }
}
