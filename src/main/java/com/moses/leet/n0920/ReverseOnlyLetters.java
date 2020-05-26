package com.moses.leet.n0920;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] ary = S.toCharArray();
        int l = 0, r = S.length()-1;
        while(l<r){
            while(l<r && !Character.isLetter(ary[l])){
                l++;
            }
            while(l<r && !Character.isLetter(ary[r])){
                r--;
            }
            char tmp = ary[l];
            ary[l] = ary[r];
            ary[r] = tmp;
            l++;
            r--;
        }
        return new String(ary);
    }
}
