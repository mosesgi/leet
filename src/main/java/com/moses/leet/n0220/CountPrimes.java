package com.moses.leet.n0220;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int res = 0;
        boolean[] ints = new boolean[n];
        ints[1] = true;     //non-prime
        for(int i=2; i<ints.length; i++){
            if(ints[i]){
                continue;
            }
            res++;
            for(long j=i; i*j<n; j++){
                ints[(int)(i*j)] = true;
            }
        }
        return res;
    }

    public int countPrimesSqrt(int n) {
        int res = 0;
        for(int i=1; i<n; i++){
            if(isPrime(i)){
                res++;
            }
        }
        return res;
    }

    public boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for(int i=2; i*i <= n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
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
