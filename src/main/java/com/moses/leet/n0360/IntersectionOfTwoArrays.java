package com.moses.leet.n0360;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }

        List<Integer> l = new ArrayList<>();
        for(int i : nums2){
            if(set.contains(i)){
                l.add(i);
                set.remove(i);
            }
        }

        int[] rst = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            rst[i] = l.get(i);
        }
        return rst;
    }
}
