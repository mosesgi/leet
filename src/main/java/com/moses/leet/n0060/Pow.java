package com.moses.leet.n0060;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {
    public double myPow(double x, int n) {
        if(n==1){
            return x;
        }else if(n==-1){
            return 1/x;
        }else if(n==0){
            return 1d;
        }
        boolean isOdd = Math.abs(n)%2==1;
        if(isOdd){
            double next = myPow(x, n/2);
            double cur = n>0?x:1/x;
            return next*next*cur;
        }else{
            double next = myPow(x, n/2);
            return next*next;
        }
    }


    int count = 0;
    public double myPowOld(double x, int n){
        if(n==0){
            return 1d;
        }
        if(n<0){
            x=1/x;
        }
        double tmp = powRecursive(x, n);
        System.out.println(count);
        return tmp;
    }

    private double powRecursive(double x, int n){
        if(n==1 || n==-1){
            return x;
        }
        double y = powRecursive(x, n/2);
        y*=y;
        if(Math.abs(n)%2 == 1){
            y = y * x;
        }
        count++;
        return y;
    }


    // time limit exceeded
    public double myPowFailed(double x, int n){
        if(n==0){
            return 1d;
        }
        if(n==1 ||x==1){
            return x;
        }
        int extraN = 0;
        if(n<0){
            if(n==Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                extraN = 1;
            } else {
                n = -n;
            }
            x=1/x;
        }
        double result = 1d;

        boolean isOdd = n%2==1;
        int calculatedN = 0;
        int quickNMax = isOdd? n-1:n;
        while(calculatedN < quickNMax - calculatedN){
            if(calculatedN == 0){
                result = x*x;
                calculatedN = 2;
            } else {
                result = result*result;
                calculatedN*=2;
            }
            count++;
        }

        int leftN = n-calculatedN;
        for(int i=0; i<leftN; i++){
            result *= x;
            count++;
        }

        for(int i=0; i<extraN; i++){
            result *= x;
            count++;
        }

        System.out.println(count);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0d, -2));
        System.out.println(new Pow().myPow(2d,-2147483648));
        System.out.println(new Pow().myPow(2.0d, 10));
        System.out.println(new Pow().myPow(2.1d, 3));
        System.out.println(new Pow().myPow(0.00001d,2147483647));
        System.out.println(new Pow().myPow(1d,2147483647));

//        System.out.println(new Pow().myPow(2.0d, 10));
//        System.out.println(new Pow().myPow(2.0d, 10));

    }
}
