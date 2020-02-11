package com.moses.leet.n0220;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n==3){
            return 1;
        } else if(n<3){
            return 0;
        }
        boolean[] nonPrime = new boolean[n];
        nonPrime[1] = true;
        for(int i=2; i<n; i++){
            if(nonPrime[i]){
                continue;
            }
            int k = n/i;
            for(int j=i; j<=k; j++){
                int rst = i*j;
                if(rst >= n){
                    continue;
                }
                nonPrime[rst]=true;
            }
        }

        int cnt = 0;
        for(int i=1; i<nonPrime.length; i++){
            if(!nonPrime[i]){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(2));
        System.out.println(new CountPrimes().countPrimes(3));
        System.out.println(new CountPrimes().countPrimes(4));
        System.out.println(new CountPrimes().countPrimes(5));
        System.out.println(new CountPrimes().countPrimes(10));
        System.out.println(new CountPrimes().countPrimes(65535));
        System.out.println(new CountPrimes().countPrimes(499979));
        System.out.println(new CountPrimes().countPrimes(1500000));
    }

}
