package com.moses.leet.n0060;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums){
        if(nums.length<1){
            return Integer.MIN_VALUE;
        }
        int tmpSum = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(tmpSum + nums[i] < nums[i]){
                tmpSum = nums[i];
            } else {
                tmpSum = tmpSum + nums[i];
            }
            if(tmpSum > max){
                max = tmpSum;
            }
        }

        return max;
    }

    public int maxSubArrayNew(int[] nums) {
        //-2,-1,-4,0,-1,1,2,-3,1
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }

        int min = 0;
        int res = nums[0];
        for(int i=0; i<nums.length; i++){
            res = Math.max(res, sum[i] - min);
            min = Math.min(min, sum[i]);
        }
        return res;
    }

    /**
     * Time limit exceeded
     * @param nums
     * @return
     */
    public int maxSubArrayObsolete(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                int tmp = 0;
                for(int k=i; k<=j; k++){
                    tmp+=nums[k];
                }
                if(tmp>max){
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));

    }
}
