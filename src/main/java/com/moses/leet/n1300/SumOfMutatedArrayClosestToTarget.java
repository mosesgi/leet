package com.moses.leet.n1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        List<Integer> origin = new ArrayList<>();
        for(int i : arr){
            origin.add(i);
        }
        while(true){
            List<Integer> next = new ArrayList<>();
            int total = 0;
            int avg = target/origin.size();
            int smallSum = 0;
            int max = 0;
            for(int i : origin){
                if(i <= avg){
                    smallSum += i;
                }else{
                    next.add(i);
                }
                total += i;
                max = Math.max(max, i);
            }
            if(total <= target){
                return max;
            }
            if(next.size()==origin.size()){
                int cand = avg+1;
                if(target - avg*origin.size() <= cand*origin.size() - target){
                    return avg;
                }else{
                    return cand;
                }
            }else{
                target -= smallSum;
                origin = next;
            }
        }

    }
}
