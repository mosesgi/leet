package com.moses.leet.n0360;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersectSorted(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //1,1,3,5,9,10,12,12
        //1,2,9,11,12
        List<Integer> l = new ArrayList<>();
        int pos1 = 0, pos2 = 0;
        while(pos1 < nums1.length && pos2 < nums2.length) {
            while (pos1 < nums1.length && pos2 < nums2.length && nums1[pos1] == nums2[pos2]) {
                l.add(nums1[pos1]);
                pos1++;
                pos2++;
            }
            if(pos1 >=nums1.length-1 || pos2 >= nums2.length-1){
                break;
            }
            if (nums1[pos1] < nums2[pos2]) {
                while (pos1 < nums1.length && nums1[pos1] < nums2[pos2]) {
                    pos1++;
                }
            } else {
                while (pos2 < nums2.length && nums1[pos1] > nums2[pos2]) {
                    pos2++;
                }
            }
        }
        int[] rst = new int[l.size()];
        for(int i =0; i<l.size(); i++){
            rst[i] = l.get(i);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums1, nums2;
        nums1 = new int[]{1,1,3,5,9,10,12,12};
        nums2 = new int[]{1,2,9,11,12};
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersectSorted(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> l = new ArrayList<>();
        for(int i : nums2){
            if(map.containsKey(i)){
                int curr = map.get(i) - 1;
                map.put(i,  curr);
                l.add(i);
                if(curr == 0){
                    map.remove(i);
                }
            }
        }

        int[] rst = new int[l.size()];
        for(int i =0; i<l.size(); i++){
            rst[i] = l.get(i);
        }
        return rst;
    }
}
