package com.moses.leet.n0520;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> nums[o2] - nums[o1]);
        for(int i=0; i<nums.length; i++){
            set.add(i);
        }
        String[] rst = new String[nums.length];
        Iterator<Integer> iter =set.iterator();
        int curr = 1;
        while(iter.hasNext()){
            int idx = iter.next();
            if(curr == 1){
                rst[idx] = "Gold Medal";
            }else if(curr == 2){
                rst[idx] = "Silver Medal";
            }else if(curr == 3){
                rst[idx] = "Bronze Medal";
            }else{
                rst[idx] = curr+"";
            }
            curr++;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,2,4,1};
        System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(nums)));
    }
}
