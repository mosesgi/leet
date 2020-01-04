package com.moses.leet;

public class DivideIntegers{
    public int divide(int dividend, int divisor) {
        int quotient = 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(divisor==1) return dividend;
        if(divisor==-1) return -dividend;
        boolean isDividendPos = true, isDivisorPos = true;
        isDividendPos = dividend<0?false:true;
        isDivisorPos = divisor<0?false:true;
        dividend = dividend>0?-dividend:dividend;
        divisor = divisor>0?-divisor:divisor;
        int remain = dividend;
        while(remain <= divisor){
            quotient++;
            remain -=divisor;
        }
        if(isDividendPos != isDivisorPos){
            quotient = -quotient;
        }
        return quotient;
    }

    public static void main(String[] args) {
        
        System.out.println(new DivideIntegers().divide(-2147483648, -1));

        System.out.println(new DivideIntegers().divide(-1, 1));
        System.out.println(new DivideIntegers().divide(10, 3));
        System.out.println(new DivideIntegers().divide(10, 2));
        System.out.println(new DivideIntegers().divide(7, -3));
    }
}