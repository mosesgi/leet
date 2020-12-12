package com.moses.leet.n0160;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        //reverse string and trim outer spaces
        int left = 0, right = chars.length-1;
        reverse(chars, left, right);
        while(left < chars.length - 1){
            if(chars[left] != ' '){
                break;
            }
            left++;
        }
        while(right >= 0){
            if(chars[right] != ' '){
                break;
            }
            right--;
        }
        if(left>right){
            return "";
        }
        int start = left, end = right;

        //reverse each word
        int wordStart = start;
        boolean letterStart = true;
        for(int i=start; i<=end; i++){
            int r = 0;
            boolean shouldReverse = false;
            if(chars[i] == ' '){
                if(letterStart) {   //if space, reverse previous word
                    letterStart = false;
                    r = i - 1;
                    shouldReverse = true;
                }
            } else {
                if(!letterStart){   //from space to first valid letter
                    wordStart = i;
                    letterStart = true;
                }
                if(i==end){
                    r = i;
                    shouldReverse = true;
                }
            }
            if(shouldReverse){
                reverse(chars, wordStart, r);
            }
        }

        //remove extra spaces in between
        int slow = start;
        boolean firstSpace = false;
        for(int fast = start; fast<=end; fast++){
            if(chars[fast] != ' '){
                chars[slow++] = chars[fast];
                firstSpace = false;
            }else{
                //first space should be added
                if(!firstSpace){
                    firstSpace = true;
                    chars[slow++] = chars[fast];
                }
            }
        }
        return new String(chars, start, slow-start);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("the sky is blue"));
        System.out.println(new ReverseWordsInString().reverseWords("  hello world!  "));
        System.out.println(new ReverseWordsInString().reverseWords("a good   example"));

    }

    public String reverseWordsOld(String s) {
        s = s.trim();
        if(s.length()<=1){
            return s;
        }
        List<String> list = new ArrayList<>();
        int len = s.length();
        for(int i=0; i<len; i++){
            if(s.charAt(i) != ' '){
                int begin = i;
                while(i<len && s.charAt(i) != ' ' ){
                    i++;
                }
                list.add(s.substring(begin, i));
                i--;
            } else if(s.charAt(i) == ' '){
                while(i<len && s.charAt(i) == ' '){
                    i++;
                }
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i));
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }


}
