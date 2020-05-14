package com.moses.leet.n0320;

import java.util.*;

public class BurstBalloons {

    //https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
    public int maxCoins(int[] nums) {
        int[] numbers = new int[nums.length+2];
        numbers[0] = 1;
        numbers[numbers.length-1] = 1;
        for(int i=0; i<nums.length; i++){
            numbers[i+1] = nums[i];
        }

        Integer[][] mem = new Integer[numbers.length][numbers.length];
        return rec(numbers, 0, numbers.length-1, mem);
    }

    private int rec(int[] numbers, int l, int r, Integer[][] mem) {
        if(l+1==r){
            return 0;
        }
        if(mem[l][r] != null){
            return mem[l][r];
        }
        int tmp = 0;
        for(int i=l+1; i<r; i++){
            tmp = Math.max(tmp, numbers[i]*numbers[l]*numbers[r] + rec(numbers, l, i, mem) + rec(numbers, i, r, mem) );
        }
        mem[l][r] = tmp;
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{3,1,5,8};
        System.out.println(new BurstBalloons().maxCoins(nums));

        nums = new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5,5};      //3830
        System.out.println(new BurstBalloons().maxCoins(nums));

    }




    Map<String, Integer> cache = new HashMap<>();
    public int maxCoinsTLE(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }

        return recursive(list);
    }

    private int recursive(List<Integer> list) {
        if(list.size()==1){
            return list.get(0);
        }
        String key = Arrays.toString(list.toArray());
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        int max = 0;
        for(int i=0; i<list.size(); i++){
            List<Integer> tmp = new ArrayList<>(list);
            tmp.remove(i);
            int cnt = recursive(tmp);
            if(i==0){
                cnt += list.get(i+1)*list.get(i);
            }else if(i == list.size()-1){
                cnt += list.get(i-1)*list.get(i);
            }else {
                cnt += list.get(i-1) * list.get(i) * list.get(i+1);
            }
            if(cnt > max){
                max = cnt;
            }
        }
        cache.put(key, max);
        return max;
    }


}
