package com.moses.leet.n0220;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    //1,2,3,4,5,6,7,8,6,9,10  3

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length < 2){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i]) <=k){
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }else {
                map.put(nums[i], i);
            }
        }
        return false;
    }


    //slowest
    public boolean containsNearbyDuplicateSlow(int[] nums, int k) {
        if(nums.length < 2){
            return false;
        }
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<=i+k && j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
