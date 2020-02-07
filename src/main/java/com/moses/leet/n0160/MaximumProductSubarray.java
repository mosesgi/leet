package com.moses.leet.n0160;

public class MaximumProductSubarray {
    //O(n)
    public int maxProduct(int[] nums){
        int rst = nums[0];
        int min = nums[0];
        int max = nums[0];
        for(int i= 1; i<nums.length; i++){
            if(nums[i] >= 0){
                max = Math.max(nums[i] * max, nums[i]);
                min = Math.min(nums[i] * min, nums[i]);
                if(max > rst){
                    rst = max;
                }
            } else if(nums[i] < 0){
                int tmp = max;
                max = Math.max(nums[i] * min, nums[i]);
                min = Math.min(nums[i] * tmp, nums[i]);
                if(max > rst){
                    rst = max;
                }
            }
        }
        return rst;
    }


    //easiest, O(n^2)
    public int maxProductON2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max = -1;
        for(int i=0; i<nums.length; i++){
            int tmp = nums[i];
            if(tmp > max){
                max = tmp;
            }
            for(int j=i+1; j<nums.length;j++){
                tmp *= nums[j];
                if(tmp > max){
                    max = tmp;
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));

        nums = new int[]{2,-5,-2,-4,3};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));

        nums = new int[]{-2,0,-1};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));

        nums = new int[]{3,-1,4};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }
}
