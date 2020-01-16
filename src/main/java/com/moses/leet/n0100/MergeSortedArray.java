package com.moses.leet.n0100;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[nums1.length];
        int n1Pos = 0; int n2Pos = 0;
        int tPos = 0;
        while(n1Pos < m && n2Pos < n){
            if(nums1[n1Pos] < nums2[n2Pos]){
                tmp[tPos++] = nums1[n1Pos++];
            } else {
                tmp[tPos++] = nums2[n2Pos++];
            }
        }
        while(n1Pos < m){
            tmp[tPos++] = nums1[n1Pos++];
        }
        while(n2Pos < n){
            tmp[tPos++] = nums2[n2Pos++];
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{3,4,7,0,0,0};
        nums2 = new int[]{2,5,6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
