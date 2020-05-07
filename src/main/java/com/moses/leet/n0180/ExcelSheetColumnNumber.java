package com.moses.leet.n0180;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int res = 0;
        int mult = 1;
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            int tmp = c-'A'+1;
            tmp*=mult;
            res+=tmp;
            mult *=26;
        }
        return res;
    }

    public int titleToNumberOld(String s) {
        int n = s.length();

        int tmp = 0;
        int pos = n;
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            int base = curr-'A'+1;
            int multi = 1;
            for(int j=1; j<pos; j++){
                multi *= 26;
            }
            tmp += base*multi;
            pos--;
        }
        return tmp;
    }


    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("A"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZZZ"));
    }

}
