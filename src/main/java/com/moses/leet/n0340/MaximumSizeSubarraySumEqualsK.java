package com.moses.leet.n0340;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 *
 * Example 1:
 *
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 *
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 * Follow Up:
 * Can you do it in O(n) time?
 *
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int max = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                max = Math.max(max, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return max;
    }

    public int maxSubArrayLen1(int[] nums, int k) {
        //1, -1, 5, -2, 3
        //1, 0,  5, 3,  6

        //-2, -1, 2, 1
        //-2, -3, -1, 0
        int[] sum = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i==0){
                sum[i] = nums[i];
            }else{
                sum[i] = nums[i] + sum[i-1];
            }
        }

        for(int j=nums.length-1; j>=0; j--){
            if(sum[j] == k){
                return j+1;
            }
            for(int i=1; i<=nums.length-j; i++){
                if(sum[i+j-1] - sum[i-1] == k){
                    return j;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums; int k;
        nums = new int[]{1,1,0};
        k = 1;
        System.out.println(new MaximumSizeSubarraySumEqualsK().maxSubArrayLen(nums, k));
    }
}
