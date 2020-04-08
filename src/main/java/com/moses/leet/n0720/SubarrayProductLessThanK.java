package com.moses.leet.n0720;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        int left = 0, right = 0, len = nums.length;
        long tmp = 1;
        while(right<len){
            if(nums[right] >=k){
                right++;
                left = right;
                tmp = 1;
                continue;
            }
            while(right < len && tmp * nums[right] < k){
                int count = right-left+1;
                cnt += count;
                tmp = tmp * nums[right];
                right++;
            }
            tmp = tmp/nums[left];
            left++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;
        k = 100;
        nums = new int[]{100,5,2,6};
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k));
    }
}
