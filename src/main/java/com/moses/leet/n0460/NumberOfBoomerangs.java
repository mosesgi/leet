package com.moses.leet.n0460;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if(points.length < 3){
            return 0;
        }
        int sum = 0;
        for(int i=0; i<points.length; i++){
            int[] a = points[i];
            Map<Long, Integer> map = new HashMap<>();
            for(int j=0; j<points.length; j++){
                if(i==j){
                    continue;
                }
                int[] b = points[j];
                long x = b[0] - a[0];
                long y = b[1] - a[1];
                long distance = x*x + y*y;
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for(int size : map.values()){
                if(size >=2){
                    sum+= size*(size-1);
                }
            }
        }
        return sum;
    }
}
