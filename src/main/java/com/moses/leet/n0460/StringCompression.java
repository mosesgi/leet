package com.moses.leet.n0460;

import java.util.Arrays;

public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length<=1){
            return chars.length;
        }
        int slow = 0;
        char prevChar = chars[0];
        int cnt = 1;
        for(int i=1; i<chars.length; i++){
            char curr = chars[i];
            if(prevChar != curr){
                chars[slow++] = prevChar;
                prevChar = curr;
                if(cnt > 1){
                    String count = String.valueOf(cnt);
                    for(char c : count.toCharArray()){
                        chars[slow++] = c;
                    }
                }
                cnt = 1;
            } else {
                cnt++;
            }
            if(i==chars.length-1){
                chars[slow++] = prevChar;
                if(cnt > 1){
                    String count = String.valueOf(cnt);
                    for(char c : count.toCharArray()){
                        chars[slow++] = c;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(chars));
        return slow;
    }

    public static void main(String[] args) {
        char[] chars;
        chars = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(new StringCompression().compress(chars));

        chars = new char[]{'a','b','c'};
        System.out.println(new StringCompression().compress(chars));

        chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new StringCompression().compress(chars));

    }
}
