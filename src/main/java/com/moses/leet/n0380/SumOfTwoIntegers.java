package com.moses.leet.n0380;

import java.math.BigDecimal;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if(a==0) return b;
        if(b==0) return a;
        while(b!=0){
            int carry = a&b;
            a = a^b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(46));
//        System.out.println(Integer.toBinaryString(-14));

        System.out.println(new SumOfTwoIntegers().getSum(46,-14));
        System.out.println(new SumOfTwoIntegers().getSum(1,2));
        System.out.println(new SumOfTwoIntegers().getSum(-2, 3));
    }
}
