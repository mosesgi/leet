package com.moses.leet.basic;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] nums){
        mergeSort(nums, 0, nums.length-1);
    }

    void mergeSort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int m = l + (r-l)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);

        int[] tmp = new int[r-l+1];
        int p = 0;
        int pl = l;
        int pr = m+1;
        while(pl <= m && pr <=r){
            if(nums[pl] <= nums[pr]){
                tmp[p++] = nums[pl++];
            }else{
                tmp[p++] = nums[pr++];
            }
        }
        while(pl <= m){
            tmp[p++] = nums[pl++];
        }
        while(pr <= r){
            tmp[p++] = nums[pr++];
        }
        for(int i=l; i<=r; i++){
            nums[i] = tmp[i-l];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,1,6,7,10,3,9,8,6};
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
