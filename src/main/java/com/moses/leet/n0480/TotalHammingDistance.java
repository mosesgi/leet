package com.moses.leet.n0480;

import java.util.HashMap;
import java.util.Map;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for(int i=0; i<32; i++){
            int mask = 1<<i;
            int ones = 0;
            for(int j=0; j<nums.length; j++){
                if((nums[j] | mask) == nums[j]){
                    ones++;
                }
            }
            sum+= (nums.length-ones) * ones;
        }
        return sum;
    }

    //TLE
    public int totalHammingDistanceON2(int[] nums) {
        //4^14 = 1010, 4^2 = 0110
        //14^2 = 1100

//        Map<Integer, Integer> dp = new HashMap<>();
        int cnt = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    continue;
                }
                int tmp = nums[i] ^ nums[j];
                cnt+= Integer.bitCount(tmp);
//                if(!dp.containsKey(tmp)){
//                    dp.put(tmp, Integer.bitCount(tmp));
//                }
//                cnt+= dp.get(tmp);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0,536870911,0,536870911,0,536870911};
        System.out.println(new TotalHammingDistance().totalHammingDistance(nums));
    }


}
