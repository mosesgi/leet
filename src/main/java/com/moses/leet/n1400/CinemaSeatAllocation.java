package com.moses.leet.n1400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int res = 0;
        int pos = 0;
        Arrays.sort(reservedSeats, (o1, o2) -> o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1]);
        int lastRow = 0;
        for(int i=1; i<=n; i++){
            if(reservedSeats[pos][0]>i){
                res+=2;
                continue;
            }
            Set<Integer> set = new HashSet<>();
            while(pos < reservedSeats.length && reservedSeats[pos][0] == i){
                set.add(reservedSeats[pos++][1]);
            }
            if(!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)){
                res+=2;
            }else if(!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)){
                res++;
            }else if(!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)){
                res++;
            }else if(!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)){
                res++;
            }
            lastRow = i;
            if(pos == reservedSeats.length){
                break;
            }
        }
        res += (n-lastRow)*2;
        return res;
    }
}
