package com.moses.leet.basic;


import java.util.Arrays;

/**
 * 第一个数作为基准数, 小的放左边, 大的放右边. 中间与最左互换
 * 递归以上
 */
public class QuickSort {

    public void sort(int[] nums){
        quick(nums, 0, nums.length-1);
    }

    void quick(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int base = nums[l];
        int i = l+1, j = r;
        while(i<j){
            while(j>i && nums[j] >= base){
                j--;
            }
            while(i<j && nums[i] < base){
                i++;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[l] = nums[i];
        nums[i] = base;
        quick(nums, l, i-1);
        quick(nums, i+1, r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,1,6,7,10,3,9,8,6};
        new QuickSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
