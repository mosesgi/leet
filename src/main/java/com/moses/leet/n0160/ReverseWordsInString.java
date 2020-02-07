package com.moses.leet.n0160;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public String reverseWords(String s) {
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

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("the sky is blue"));
        System.out.println(new ReverseWordsInString().reverseWords("  hello world!  "));
        System.out.println(new ReverseWordsInString().reverseWords("a good   example"));

    }
}
