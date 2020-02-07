package com.moses.leet.n0180;

import java.math.BigDecimal;
import java.math.RoundingMode;

//https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        BigDecimal num = BigDecimal.valueOf(numerator);
        BigDecimal den = BigDecimal.valueOf(denominator);
        BigDecimal rst = num.divide(den, 1000, RoundingMode.HALF_UP);
        System.out.println(rst);
        return "";
    }

    public static void main(String[] args) {
        new FractionToRecurringDecimal().fractionToDecimal(13,7 );
    }
}
