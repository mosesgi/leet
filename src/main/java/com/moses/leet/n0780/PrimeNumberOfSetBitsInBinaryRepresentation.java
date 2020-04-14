package com.moses.leet.n0780;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>();
        outer: for(int i=2; i<=32; i++){
            for(int j=2; j<i; j++){
                if(i%j == 0){
                    continue outer;
                }
            }
            primes.add(i);
        }
        int cnt = 0;
        for(int i=L; i<=R; i++){
            int tmp = 0;
            int k = i;
            while(k>0){
                if((k|1)==k){
                    tmp++;
                }
                k>>>=1;
            }
            if(primes.contains(tmp)){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new PrimeNumberOfSetBitsInBinaryRepresentation().countPrimeSetBits(6, 10));
        System.out.println(new PrimeNumberOfSetBitsInBinaryRepresentation().countPrimeSetBits(10, 15));
    }
}
