package com.moses.leet.n0740;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] ary = new int[10001];
        for(int i : nums){
            ary[i] = ary[i] + i;        //sum together
        }

        int[] skip = new int[10001];
        int[] include = new int[10001];

        include[0] = ary[0];
        for(int i=1; i<ary.length; i++){
            skip[i] = Math.max(skip[i-1], include[i-1]);
            include[i] = ary[i] + skip[i-1];
        }
        return Math.max(skip[10000], include[10000]);
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{3,4,2};
        System.out.println(new DeleteAndEarn().deleteAndEarn(nums));

        nums = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
    }
}
