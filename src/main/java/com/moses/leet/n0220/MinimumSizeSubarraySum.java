package com.moses.leet.n0220;

public class MinimumSizeSubarraySum {
    //O(NLogN), sum array(sum from begin to i) and binary search. Cannot figure it out by myself...


    public int minSubArrayLen(int s, int[] nums) {
        int l=0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int r = 0; r<nums.length; r++){
            sum += nums[r];
            while(sum >= s){
                res = Math.min(res, r-l+1);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }

    //O(n), can be simplified
    public int minSubArrayLenOld(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int tmpSum = nums[left];
        int minLen = nums.length;
        boolean found = false;

        while(left<=right && right < nums.length-1){
            if(left == right && nums[left] > s){
                return 1;
            }
            while(tmpSum < s && right < nums.length-1){
                right++;
                tmpSum += nums[right];
            }
            if(tmpSum >= s) {
                found = true;
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                }
            }

            while(tmpSum >= s && left <=right){
                tmpSum -= nums[left];
                left++;
            }
            if(found) {
                int len = right - left + 2;
                if (len < minLen) {
                    minLen = len;
                }
            }
        }

        if(!found){
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        int s;
        int[] nums;
        s=15;
        nums = new int[]{1,2,3,4,5};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s, nums));

        s=7;
        nums = new int[]{2,3,1,2,4,3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s, nums));

        s=9;
        nums = new int[]{2,3,1,2};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s, nums));

        s=9;
        nums = new int[]{2,3,1,2,7,4,2,10,3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s, nums));
    }

}
