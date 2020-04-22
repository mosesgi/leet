package com.moses.leet.n0040;

import java.util.Arrays;

public class NextPermutation{
    public void nextPermutation(int[] nums) {
        int l=-1, r = nums.length-1;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i-1] < nums[i]){        //find first decreasing from end
                l = i-1;
                break;
            }
        }
        if(l!=-1) {
            //find minimum element greater than nums[l]
            Integer candPos = null;
            for (int i = nums.length-1; i > l; i--) {
                if (nums[i] > nums[l] && (candPos == null || nums[i] < nums[candPos])) {
                    candPos = i;
                }
            }
            //switch l with candPos
            swap(l, candPos, nums);
        }
        //reverse all elements after l
        l++;
        while(l < r){
            swap(l, r, nums);
            l++;
            r--;
        }
    }

    void swap(int l, int r, int[] nums){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{2,3,1};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2,3,1,3,3};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,2,3};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,3,2};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,2,4,3};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3,2,1};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,1,5};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,2,3,5,4};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));


        nums = new int[]{4,3,5,1,1};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4,3,5,1,2};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }



    public void nextPermutationOld(int[] nums){
        int indexChanged = 0;
        for(int i= nums.length -1; i>0; i--){
            if(nums[i] > nums[i-1]){
                int tmp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = tmp;
                indexChanged = i;
                break;
            }
        }

        Arrays.sort(nums, indexChanged, nums.length);
    }


}