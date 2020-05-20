package com.moses.leet.basic;

import java.util.Arrays;

/**
 * 希尔排序, based on 插入排序. 跨步地插入
 */
public class ShellSort {

    public void sort(int[] nums){
        int step;
        for(step = nums.length/2; step> 0; step/=2){
            for(int i=step; i<nums.length; i++){
                int j=i;
                int cur = nums[i];
                while(j-step>=0 && cur < nums[j-step]){
                    nums[j] = nums[j-step];
                    j-=step;
                }
                nums[j] = cur;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,1,6,7,10,3,9,8,6};
        new ShellSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
