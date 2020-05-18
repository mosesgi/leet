package com.moses.leet.n0380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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


    public List<Integer> largestDivisibleSubsetRec(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[][] cache = new List[nums.length][nums.length];
        return dfs(nums, 0, null, cache);
    }

    List<Integer> dfs(int[] nums, int pos, Integer prev, List<Integer>[][] cache){
        if(pos >= nums.length){
            return new LinkedList<>();
        }

        List<Integer> res1 = new LinkedList<>();
        List<Integer> res2 = new LinkedList<>();
        if(prev == null){
            List<Integer> n1 = dfs(nums, pos+1, pos, cache);
            res1.add(nums[pos]);
            res1.addAll(n1);
            List<Integer> n2 = dfs(nums, pos+1, null, cache);
            res2.addAll(n2);
            return res1.size() >= res2.size()?res1:res2;
        }else{
            if(cache[prev][pos] != null){
                return cache[prev][pos];
            }
            if(nums[pos] % nums[prev] == 0){
                List<Integer> n1 = dfs(nums, pos+1, pos, cache);
                res1.add(nums[pos]);
                res1.addAll(n1);
                List<Integer> n2 = dfs(nums, pos+1, prev, cache);
                res2.addAll(n2);
                cache[prev][pos] = res1.size() >= res2.size()?res1:res2;
            }else{
                cache[prev][pos] = dfs(nums, pos+1, prev, cache);
            }
        }
        return cache[prev][pos];
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
