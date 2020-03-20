package com.moses.leet.n0500;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            int big = -1;
            for(int j=i+1; j<nums2.length; j++){
                if(nums2[j] > nums2[i]){
                    big = nums2[j];
                    break;
                }
            }
            map.put(nums2[i], big);
        }
        int[] rst = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            rst[i] = map.get(nums1[i]);
        }
        return rst;
    }
}
