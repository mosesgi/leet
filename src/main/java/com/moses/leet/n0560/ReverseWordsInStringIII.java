package com.moses.leet.n0560;

import java.util.Arrays;

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        int start = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i<chars.length; i++){
            if(chars[i] == ' '){
                swap(chars, start, i-1);
                start = i+1;
            }
            if(i == chars.length-1){
                swap(chars, start, i);
            }
        }
        return new String(chars);
    }

    void swap(char[] chars, int start, int end){
        while(start < end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }


    public String reverseWords1(String s) {
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
