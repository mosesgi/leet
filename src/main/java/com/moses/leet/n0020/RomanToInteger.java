package com.moses.leet.n0020;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s){
        int num = 0;
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    num += num>=5?-1:1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num += num >= 50?-10:10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    num += num >= 500?-100:100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
        }
        return num;
    }

    public int romanToIntOld(String s){
        Map<String, Integer> basic = new HashMap<String, Integer>();
        basic.put("I", 1);
        basic.put("IV", 4);
        basic.put("V", 5);
        basic.put("IX", 9);
        basic.put("X", 10);
        basic.put("XL", 40);
        basic.put("L", 50);
        basic.put("XC", 90);
        basic.put("C", 100);
        basic.put("CD", 400);
        basic.put("D", 500);
        basic.put("CM", 900);
        basic.put("M", 1000);
        int i=0;
        int result = 0;
        while(i<s.length()){
            if (s.substring(i).length()>=2 && basic.get(s.substring(i, i + 2)) != null) {
                result += basic.get(s.substring(i, i + 2));
                i+=2;
            } else {
                result += basic.get(s.substring(i, i+1));
                i+=1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger roman = new RomanToInteger();
        System.out.println(roman.romanToInt("III"));
        System.out.println(roman.romanToInt("IV"));
        System.out.println(roman.romanToInt("IX"));
        System.out.println(roman.romanToInt("LVIII"));
        System.out.println(roman.romanToInt("MCMXCIV"));

    }
}
