package com.moses.leet.n0180;


//https://leetcode.com/problems/factorial-trailing-zeroes/discuss/196311/topic
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return 0;
    }

    public long factorial(int n){
        long tmp = 1;
        while(n>0){
            tmp*=n;
            n--;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(3));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(5));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(20));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(95));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(625));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(1808548329));
    }
}
