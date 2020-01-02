package com.moses.leet;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public String intToRoman(int num){
        Map<Integer, String> basic = new HashMap<Integer, String>();
        basic.put(1, "I");
        basic.put(4, "IV");
        basic.put(5, "V");
        basic.put(9, "IX");
        basic.put(10, "X");
        basic.put(40, "XL");
        basic.put(50, "L");
        basic.put(90, "XC");
        basic.put(100, "C");
        basic.put(400, "CD");
        basic.put(500, "D");
        basic.put(900, "CM");
        basic.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        if(num/1000 > 0){
            int thousand = num/1000;
            for(int i=0; i<thousand; i++){
                sb.append(basic.get(1000));
            }
            num = num%1000;
        }

        for(int j=100; j>=1; j=j/10) {
            if (num / j > 0) {
                int digit = num / j;
                if (digit == 9) {
                    sb.append(basic.get(9*j));
                } else if (digit >= 5 && digit < 9) {
                    sb.append(basic.get(5*j));
                    for (int i = 0; i < digit - 5; i++) {
                        sb.append(basic.get(1*j));
                    }
                } else if (digit == 4) {
                    sb.append(basic.get(4*j));
                } else {
                    for (int i = 0; i < digit; i++) {
                        sb.append(basic.get(1*j));
                    }
                }
                num = num%j;
            }
        }

        return sb.toString();

    }


    public static void main(String[] args) {
        IntegerToRoman roman = new IntegerToRoman();

        System.out.println(roman.intToRoman(3));
        System.out.println(roman.intToRoman(4));
        System.out.println(roman.intToRoman(9));
        System.out.println(roman.intToRoman(58));
        System.out.println(roman.intToRoman(1994));
    }
}
