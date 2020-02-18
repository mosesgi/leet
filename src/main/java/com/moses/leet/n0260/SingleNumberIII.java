package com.moses.leet.n0260;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                set.remove(i);
            }else {
                set.add(i);
            }
        }
        int[] rst = new int[2];
        Iterator<Integer> iter = set.iterator();
        rst[0] = iter.next();
        rst[1] = iter.next();
        return rst;
    }
}
