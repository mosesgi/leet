package com.moses.leet.n0380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //1,2,3,4,5,6,9,12,18,24
        //1,3,9,18
        //1,3,6,12,24
        //1,3,6,18
        //1,2,4,12,24
        //1,2,6,12,24
        //1,2,6,18
        //1,2,6,18
        if(nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<Integer>[] cache = new ArrayList[nums.length];
        for(int i=0; i<cache.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            cache[i] = list;
        }

        for(int i=nums.length-2; i>=0; i--){
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]%nums[i] == 0 && cache[j].size()+1 > cache[i].size()){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(cache[j]);
                    cache[i] = list;
                }
            }
        }

        int maxCnt = 0;
        int pos = 0;
        for(int i=0; i<cache.length; i++){
            if(cache[i].size() > maxCnt){
                maxCnt = cache[i].size();
                pos = i;
            }
        }
        return cache[pos];
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,2,3};
        System.out.println(Arrays.toString(new LargestDivisibleSubset().largestDivisibleSubset(nums).toArray()));

        nums = new int[]{1,2,4,8};
        System.out.println(Arrays.toString(new LargestDivisibleSubset().largestDivisibleSubset(nums).toArray()));

        nums = new int[]{1,2,3,4,5,6,9,12,18,24};
        System.out.println(Arrays.toString(new LargestDivisibleSubset().largestDivisibleSubset(nums).toArray()));
    }
}
