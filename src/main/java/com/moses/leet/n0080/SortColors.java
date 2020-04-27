package com.moses.leet.n0080;

import java.util.Arrays;

public class SortColors {
    //2,0,1,2,0,1,0
    //0,0,1,2,0,1,2
    //0,0,1,1,0,2,2
    //0,0,0,1,1,2,2

    //1,1,0,2,0,2,1
    //0,1,1,2,0,2,1
    //0,1,1,1,0,2,2
    //0,0,1,1,1,2,2
    public void sortColors(int[] nums) {
        int l=0, r = nums.length-1;
        int first1 = Integer.MAX_VALUE;
        while(l<=r){
            if(nums[l] == 1 && first1 > l ){
                first1 = l;
            }
            if(nums[l] == 2){
                while(r-1 > l && nums[r] == 2){
                    r--;
                }
                swap(nums, l, r);
                if(nums[l] == 1 && first1 > l){
                    first1 = l;
                }
            }
            if(nums[l] == 0){
                if(first1 < l){
                    swap(nums, l, first1);
                    first1++;
                }
            }
            l++;
        }
    }

    void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public void sortColorsOld(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zero++;
            } else if(nums[i] == 1){
                one++;
            } else{
                two++;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(zero>0){
                nums[i] = 0;
                zero--;
            } else if(one >0){
                nums[i] = 1;
                one--;
            } else {
                nums[i] = 2;
                two--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,1,0,2,0,2,1};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
