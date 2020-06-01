package com.moses.leet.n0280;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    private final String[] belowTwenty = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int i=0;
        String words = "";
        while(num > 0){
            if(num%1000 != 0){
                words = helper(num%1000) + thousands[i] + " " + words;
            }
            num/=1000;
            i++;
        }
        return words.trim();
    }

    String helper(int num){
        if(num == 0){
            return "";
        }else if(num < 20){
            return belowTwenty[num] + " ";
        }else if(num < 100){
            return tens[num/10] + " " + helper(num%10);
        }else{
            return belowTwenty[num/100] + " Hundred " + helper(num%100);
        }
    }

    public String numberToWordsOld(int num) {
        if(num==0){
            return "Zero";
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");

        Map<Integer, String> tenMap = new HashMap<>();
        tenMap.put(2, "Twenty");
        tenMap.put(3, "Thirty");
        tenMap.put(4, "Forty");
        tenMap.put(5, "Fifty");
        tenMap.put(6, "Sixty");
        tenMap.put(7, "Seventy");
        tenMap.put(8, "Eighty");
        tenMap.put(9, "Ninety");

        StringBuilder sb = new StringBuilder();

        String[] threes = new String[]{"Thousand", "Million", "Billion"};
        int three = -1;
        while(num > 0){
            if(num%1000 == 0){
                three++;
                num/=1000;
                continue;
            }
            if(three>=0){
                if(sb.length() != 0){
                    sb.insert(0, " ");
                }
                sb.insert(0, threes[three]);
            }
            int lastTwo = num%100;
            if(lastTwo >0 && lastTwo <20){
                if(sb.length() != 0){
                    sb.insert(0, " ");
                }
                sb.insert(0, map.get(lastTwo));
                num/=100;
            } else {
                if(num%10 != 0) {
                    if(sb.length() != 0){
                        sb.insert(0, " ");
                    }
                    sb.insert(0, map.get(num % 10));
                }
                num/=10;
                if(num==0){
                    return sb.toString();
                }
                if(num%10 != 0) {
                    if(sb.length() != 0){
                        sb.insert(0, " ");
                    }
                    sb.insert(0, tenMap.get(num % 10));
                }
                num/=10;
            }
            if(num==0){
                return sb.toString();
            }
            if(num%10 != 0) {
                if(sb.length() != 0){
                    sb.insert(0, " ");
                }
                sb.insert(0, map.get(num % 10) + " Hundred");
            }
            num/=10;
            if(num==0){
                return sb.toString();
            }
            three++;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords().numberToWords(20));
        System.out.println(new IntegerToEnglishWords().numberToWords(12200000));
        System.out.println(new IntegerToEnglishWords().numberToWords(12345612));
        System.out.println(new IntegerToEnglishWords().numberToWords(1234567891));
    }
}
