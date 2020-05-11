package com.moses.leet.n0220;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0){
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            Integer r = set.ceiling(nums[i]);
            Integer l = set.floor(nums[i]);
            if(r != null && r-nums[i] <= k || l!=null && nums[i] - l<=k){
                return true;
            }
            set.add(nums[i]);
            if(i>=k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -1};
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, 1, -1));
    }


    //slowest
    public boolean containsNearbyAlmostDuplicateSlow(int[] nums, int k, int t) {
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<=i+k && j<nums.length; j++){
                if(Math.abs((long)nums[j]-(long)nums[i]) <= (long)t){
                    return true;
                }
            }
        }
        return false;
    }
}
