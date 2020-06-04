package com.moses.leet.n0180;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 *
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums.length==0){
            if(lower == upper){
                res.add(lower+"");
            }else{
                res.add(lower+"->" + upper);
            }
            return res;
        }
        if(nums[0]>lower){
            if((long)nums[0] == 1 + (long)lower){
                res.add(lower+"");
            }else if((long)nums[0] > 1 + (long)lower){
                res.add(lower+"->" + (nums[0]-1));
            }
        }
        for(int i=1; i<nums.length; i++){
            long prev = nums[i-1];
            long curr = nums[i];
            if(curr == 2 + prev){
                res.add((prev+1) + "");
            }else if(curr > 2 + prev){
                res.add((prev+1) + "->" + (curr-1));
            }
        }
        if(nums[nums.length-1] < upper){
            if((long)upper - (long)nums[nums.length-1] == 1){
                res.add(upper+"");
            }else if((long)upper - (long)nums[nums.length-1] > 1){
                res.add((nums[nums.length-1]+1) +"->" + upper);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums; int lower, upper;
        nums = new int[]{-2147483648,2147483647};
        lower = -2147483648;
        upper = 2147483647;
        System.out.println(new MissingRanges().findMissingRanges(nums, lower, upper));

    }
}
