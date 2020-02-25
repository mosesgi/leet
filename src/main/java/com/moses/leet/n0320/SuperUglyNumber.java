package com.moses.leet.n0320;

import java.util.*;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] rst = new int[n];
        int[] indexes = new int[primes.length];
        rst[0] = 1;

        for(int i=1; i<n; i++) {
            rst[i] = Integer.MAX_VALUE;
            List<Integer> dup = new ArrayList<>();
            for (int j = 0; j < primes.length; j++) {
                int curr = primes[j] * rst[indexes[j]];
                if(curr < rst[i]){
                    dup.clear();
                    dup.add(j);
                    rst[i] = curr;
                } else if(curr  == rst[i]){
                    dup.add(j);
                }
            }
            for(Integer k : dup){
                indexes[k]++;
            }
        }
        return rst[n-1];
    }

    public int nthSuperUglyNumberSlow(int n, int[] primes) {
        int[] indexes = new int[primes.length];
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int cnt = 1;
        while(cnt<n){
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();
            for(int i=0; i<primes.length; i++){
                int key = primes[i] * (list.get(indexes[i]));
                if(map.containsKey(key)){
                    map.get(key).add(i);
                }else {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    map.put(key, l);
                }
            }
            Integer key = map.firstKey();
            list.add(key);
            for(Integer k : map.get(key)){
                indexes[k]++;
            }
            cnt++;
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        int n;
        int[] primes;
        n=12;
        primes = new int[]{2,7,13,19};
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(n, primes));
    }
}
