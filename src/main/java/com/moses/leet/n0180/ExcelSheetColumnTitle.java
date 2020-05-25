package com.moses.leet.n0180;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }

    public String convertToTitleMine(int n) {
        //52 - AZ; 53 - BA
        //AAA - 703.
        //ZZ - 702
        //BZ - 26*2 + 26 = 78
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(n%26 == 0){
                sb.insert(0, 'Z');
                n = n/26-1;
            }else{
                sb.insert(0, (char)('A' + n%26 - 1));
                n = n/26;
            }
        }
        return sb.toString();
    }

    public String convertToTitleOld(int n) {
        Map<Integer, Character> map = new HashMap<>();
        char a = 'A';
        for(int i=1; i<=26; i++){
            char tmp = (char)(a+i-1);
            map.put(i, tmp);
        }

        StringBuilder sb = new StringBuilder();
        while(n>26){
            if(n%26==0){
                sb.insert(0, 'Z');
                n = n/26 -1;
            } else {
                sb.insert(0, map.get(n%26));
                n = n/26;
            }
        }
        sb.insert(0, map.get(n));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(2));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(52));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(703));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(17576));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(18278));
    }
}
