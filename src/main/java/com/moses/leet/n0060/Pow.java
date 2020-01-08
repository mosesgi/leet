package com.moses.leet.n0060;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {
    public double myPow(double x, int n){
        if(n==0){
            return 1d;
        }
        boolean isPowNeg = false;
        if(n<0){
            isPowNeg = true;
            n=-n;
        }
        double result = 1d;
        for(int i=0; i<n; i++){
            result*=x;
        }
        if(isPowNeg){
            result=1/result;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0d, 10));
        System.out.println(new Pow().myPow(2.1d, 3));
        System.out.println(new Pow().myPow(2.0d, -2));
        System.out.println(new Pow().myPow(0.00001d,2147483647));
//        System.out.println(new Pow().myPow(2.0d, 10));
//        System.out.println(new Pow().myPow(2.0d, 10));

    }
}
