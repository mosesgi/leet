package com.moses.leet.n1460;

public class MaxDotProductOfTwoSubsequences {
    Integer[][] mem;
    public int maxDotProductWRONG_ANSWER(int[] nums1, int[] nums2) {
        mem = new Integer[nums1.length][nums2.length];
        return back(nums1, nums2, 0, 0);
    }

    int back(int[] nums1, int[] nums2, int p1, int p2){
        if(p1 == nums1.length || p2==nums2.length){
            return 0;
        }
        if(mem[p1][p2] != null){
            return mem[p1][p2];
        }
        int next1 = back(nums1, nums2, p1+1, p2);
        int next2 = back(nums1, nums2, p1, p2+1);
        int next3 = nums1[p1]*nums2[p2] + back(nums1, nums2, p1+1, p2+1);
        mem[p1][p2] =  Math.max(Math.max(next1, next2), next3);
        return mem[p1][p2];
    }
}
