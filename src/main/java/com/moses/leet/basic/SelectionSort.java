package com.moses.leet.basic;

import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] nums){
        //选最小的, 放最前面
        for(int i=0; i<nums.length; i++){
            int pos = i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] < nums[pos]){
                    pos = j;
                }
            }
            if(pos != i){
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,1,6,7,10,3,9,8,6};
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
