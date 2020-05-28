package com.moses.leet.n0340;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
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
