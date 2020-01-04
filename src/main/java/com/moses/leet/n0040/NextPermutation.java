package com.moses.leet.n0040;

import java.util.Arrays;

public class NextPermutation{
    public void nextPermutation(int[] nums){
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

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
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
}