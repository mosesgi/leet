package com.moses.leet.n0340;

import java.util.Arrays;

//O(N) & O(1) space solution
// https://leetcode.com/problems/wiggle-sort-ii/discuss/77688/O(n)%2BO(1)-after-median-without-Virtual-Indexing-%3A-)
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copy = new int[nums.length];
        int len = nums.length;
        for(int i=0; i<len; i++){
            copy[i] = nums[i];
        }
        int mid = len%2==0?len/2-1:len/2;
        int left = mid;
        int right = len-1;
        int k=0;
        while(left >=0 && right >= mid+1){
            nums[k++] = copy[left--];
            nums[k++] = copy[right--];
        }
        if(left >= 0){
            nums[k] = copy[left];
        }
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 5, 1, 1, 6, 4};
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 3, 2, 2, 3, 1};
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
