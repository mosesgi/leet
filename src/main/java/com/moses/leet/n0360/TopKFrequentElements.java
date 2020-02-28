package com.moses.leet.n0360;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length==0 || k==0){
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }

        Set<Integer> set = map.keySet();
        for(Integer key : set){
            buckets[map.get(key)].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=buckets.length-1; i>=0; i--){
            if(buckets[i].isEmpty()){
                continue;
            }
            result.addAll(buckets[i]);
            if(result.size() >=k){
                break;
            }
        }
        return result.subList(0, k);
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,1,1,2,2,3};
        System.out.println(new TopKFrequentElements().topKFrequent(nums, 2));

        nums = new int[]{1};
        System.out.println(new TopKFrequentElements().topKFrequent(nums, 1));
    }
}
