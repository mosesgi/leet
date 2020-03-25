package com.moses.leet.n0540;

import java.util.List;
import java.util.TreeSet;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> set = new TreeSet<>();
        for(String s : timePoints){
            String[] strs = s.split(":");
            int min = Integer.parseInt(strs[0])*60 + Integer.parseInt(strs[1]);
            if(set.contains(min)){
                return 0;
            }
            set.add(min);
        }

        int min = Integer.MAX_VALUE;
        Integer prev = null;
        for(int s : set){
            if(prev != null){
                min = Math.min(min, s-prev);
            }
            prev = s;
        }
        min = Math.min(min, set.first()+1440 - set.last());
        return min;
    }
}
