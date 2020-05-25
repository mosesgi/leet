package com.moses.leet.n0180;


//https://leetcode.com/problems/factorial-trailing-zeroes/discuss/196311/topic
public class FactorialTrailingZeroes {
    //25!结果不只是25/5=5个0，25结果有6个0,因为25=5*5，有两个5。所以结果f(n)=n/5+f(n/5)!
    public int trailingZeroes(int n) {
        if(n==0){
            return 0;
        }
        return n/5+trailingZeroes(n/5);
    }

    public int trailingZeroesIterative(int n) {
        int res = 0;
        while(n > 0){
            res += n/5;
            n = n/5;
        }
        return res;
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
