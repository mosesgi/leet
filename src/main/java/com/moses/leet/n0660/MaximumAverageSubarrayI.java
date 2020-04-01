package com.moses.leet.n0660;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<k; i++){
            sum+= nums[i];
        }
        double avg = sum*1.0d/k;
        for(int i=0; i<nums.length-k; i++){
            int right = i+k;
            sum = sum-nums[i] + nums[right];
            avg = Math.max(avg, sum*1.0d / k);
        }
        return avg;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;
        nums = new int[]{1,12,-5,-6,50,3};
        k = 4;
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(nums, k));
    }
}
