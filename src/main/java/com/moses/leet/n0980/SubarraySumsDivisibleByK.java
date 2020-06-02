package com.moses.leet.n0980;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        int s = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0; i<A.length; i++){
            s += A[i];
            int m = (s%K +K)%K;
            map.put(m, map.getOrDefault(m, 0) + 1);
        }
        int res = 0;
        for(int k : map.keySet()){
            int v = map.get(k);
            res += v*(v-1)/2;
        }
        return res;
    }

    public String minNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            numbers[i] =nums[i];
        }
        Arrays.sort(numbers, (o1, o2) -> (o1+""+o2).compareTo(o2+""+o1));
        StringBuilder sb= new StringBuilder();
        for(int i : numbers){
            sb.append(i);
        }
        return sb.toString();
    }
}
