package com.moses.leet.n0700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> startMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
            if(!startMap.containsKey(nums[i])){
                startMap.put(nums[i], i);
            }
            if(cntMap.get(nums[i]) > max){
                max = cntMap.get(nums[i]);
                min = i-startMap.get(nums[i])+1;
            }else if(cntMap.get(nums[i]) == max){
                min = Math.min(min, i-startMap.get(nums[i])+1);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,2,2,3,1};
        System.out.println(new DegreeOfAnArray().findShortestSubArray(nums));
        nums = new int[]{1,2,2,3,1,4,2};
        System.out.println(new DegreeOfAnArray().findShortestSubArray(nums));

    }
}
