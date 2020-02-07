package com.moses.leet.n0180;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElementMap(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int cnt = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i]) + 1 > cnt){
                    return nums[i];
                }
                map.put(nums[i], map.get(nums[i])+1);
            } else{
                map.put(nums[i], 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
