package com.moses.leet.n0180;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
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
