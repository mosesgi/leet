package com.moses.leet.n0920;

import java.util.Arrays;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int[] help = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            help[i] = nums[i];
        }
        mergeSort(nums, 0, nums.length, help);
        return nums;
    }

    void mergeSort(int[] nums, int l, int r, int[] help){
        if(r-l<=1){
            return;
        }
        int m = l+(r-l)/2;
        mergeSort(nums, l, m, help);
        mergeSort(nums, m, r, help);
        int p = l, q = m;
        int idx = l;
        while(p<m && q < r){
            if(nums[p] <= nums[q]){
                help[idx++] = nums[p++];
            }else{
                help[idx++] = nums[q++];
            }
        }
        while(p<m){
            help[idx++] = nums[p++];
        }
        while(q<r){
            help[idx++] = nums[q++];
        }
        for(int i=l; i<r; i++){
            nums[i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(new SortAnArray().sortArray(nums)));
    }
}
