package com.moses.leet.n0200;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    void reverse(int[] nums, int l, int r){
        while(l<r){
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
            l++;
            r--;
        }
    }

    //O(1), beat 100%
    public void rotateOld(int[] nums, int k){
        if(nums.length <=1 ){
            return;
        }
        int len = nums.length;
        k = k%len;
        int remain = len-k;
        int[] rem = new int[remain];
        for(int i=0; i<remain; i++){
            rem[i] = nums[i];
        }

        int j = 0;
        for(int i=remain; i<len; i++){
            nums[j++] = nums[i];
        }

        for(int i=0; i<remain; i++){
            nums[j++] = rem[i];
        }
    }

    public void rotateO1Space(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        int len = nums.length;
        k = k%len;

        for(int i=0; i<k; i++){
            int tmp = nums[len-1];
            for(int j=len-1; j>=1; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = tmp;
        }
    }

    public static void main(String[] args) {

        int[] nums;
        int k;

        nums = new int[]{1,2,3,4,5,6,7};
        k = 3;
        new RotateArray().rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{-1,-100,3,99};
        k = 2;
        new RotateArray().rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }
}
