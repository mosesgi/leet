package com.moses.leet.n0560;

import java.util.Arrays;

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length; i++){
            char[] str = strs[i].toCharArray();
            int l = 0, r = str.length-1;
            while(l<r){
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
            String rev = String.valueOf(str);
            sb.append(rev).append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s;
        s = "Let's take LeetCode contest";
        System.out.println(new ReverseWordsInStringIII().reverseWords(s));
    }
}
