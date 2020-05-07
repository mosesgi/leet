package com.moses.leet.n0180;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(numerator > 0 && denominator<0 || numerator<0 && denominator > 0){
            sb.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num/den);
        num = num%den;

        if(num==0){
            return sb.toString();
        }

        sb.append(".");
        num*=10;
        while(num < den){
            sb.append("0");
            num *=10;
        }
        Map<Long, Integer> map = new HashMap<>();
        while(num != 0){
            if(map.containsKey(num)){
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            }else{
                int tmp = (int)(num/den);
                map.put(num, sb.length());
                sb.append(tmp);
            }
            num = num%den;
            num*=10;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-50,8));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1,-2147483648));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(13,7 ));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(13,179 ));
    }
}
