package com.moses.leet.basic;

import java.util.Arrays;

public class InsertionSort {

    //待处理数, 插到前面已排序好的中间
    public void sort(int[] nums){
        for(int i=1; i<nums.length; i++){
            int cur = nums[i];

            int j = i;
            while(j > 0 && cur < nums[j-1]){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = cur;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,1,6,7,10,3,9,8,6};
        new InsertionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
