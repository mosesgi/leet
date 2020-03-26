package com.moses.leet.n0580;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    //1,1,1,2,2,2,3,3
    //1,2,3,4,5,5,5,5
    //1,2,2,2,2,2,5,5
    //1,2,3,4,5,6,7,8
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int i : candies){
            set.add(i);
        }
        if(set.size() < candies.length/2){
            return set.size();
        }else{
            return candies.length/2;
        }
    }
}
