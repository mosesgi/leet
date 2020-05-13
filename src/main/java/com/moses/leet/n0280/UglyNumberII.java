package com.moses.leet.n0280;

import java.util.*;

public class UglyNumberII {



    // 2,3,5 乘以之前的ugly number, 比谁小, 索引+1
    public int nthUglyNumber(int n){
        int[] cache = new int[n+1];
        cache[1] = 1;
        int inc2 = 1, inc3 = 1, inc5 = 1;
        int fac2 = 0, fac3 = 0, fac5 = 0;
        for(int i=1; i<n; i++){
            fac2 = 2*cache[inc2];
            fac3 = 3*cache[inc3];
            fac5 = 5*cache[inc5];
            int min = Math.min(Math.min(fac2, fac3), fac5);
            cache[i+1] = min;
            if(fac2 == min){
                inc2++;
            }
            if(fac3 == min){
                inc3++;
            }
            if(fac5 == min){
                inc5++;
            }
        }
        return cache[n];
    }

    public int nthUglyNumber2(int n) {
        TreeSet<Long> set = new TreeSet<>();        //use long, 如果用integer会丢失精度
        set.add(1L);
        for(int i=1; i<n; i++){
            Long prev = set.pollFirst();
            set.add(2 * prev);
            set.add(3 * prev);
            set.add(5 * prev);
        }
        return set.pollFirst().intValue();
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
        System.out.println(new UglyNumberII().nthUglyNumber(1600));     //1399680000
        System.out.println(new UglyNumberII().nthUglyNumber(30));
        System.out.println(new UglyNumberII().nthUglyNumber(1690));
    }
}
