package com.moses.leet.n0140;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    //O(n) but actually it's slower.
    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }

        int longest = 0;
        for(int i : nums){
            int tmp = 1;
            if(set.contains(i-1)){
                continue;
            }
            int j = i;
            while(set.contains(j+1)){
                tmp++;
                j++;
            }
            longest = Math.max(tmp, longest);
        }
        return longest;
    }

    //O(NlogN)
    public int longestConsecutiveLogN(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int tmp = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1] + 1){
                tmp++;
            }else if(nums[i] == nums[i-1]){
                continue;
            }else{
                max = Math.max(tmp, max);
                tmp = 1;
            }
        }
        max = Math.max(tmp, max);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));

        nums = new int[]{0,0,1,-1};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));

        nums = new int[]{0,-1};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));

        nums = new int[]{0,0};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));

    }
}
