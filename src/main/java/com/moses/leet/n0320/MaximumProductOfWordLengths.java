package com.moses.leet.n0320;

import java.util.HashSet;
import java.util.Set;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        int[] vals = new int[words.length];
        for(int i=0; i<words.length; i++){
            for(char c : words[i].toCharArray()){
                vals[i] |= (1<<(c-'a'));
            }
        }
        int max = 0;
        for(int i=0; i<words.length-1; i++){
            int iLen = words[i].length();
            for(int j=i+1; j<words.length; j++){
                if((vals[i] & vals[j]) == 0 && iLen * words[j].length() > max){
                    max = iLen * words[j].length();
                }
            }
        }
        return max;
    }

    public int maxProductMyOwnSlow(String[] words) {
        int max = 0;
        for(int i=0; i<words.length-1; i++){
            Set<Character> iSet = new HashSet<>();
            for(char c : words[i].toCharArray()){
                iSet.add(c);
            }
            int iLen = words[i].length();
            inner: for(int j=i+1; j<words.length; j++){
                for(char d : words[j].toCharArray()){
                    if(iSet.contains(d)){
                        continue inner;
                    }
                }
                int tmp = iLen * words[j].length();
                if(tmp > max){
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words;
        words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(new MaximumProductOfWordLengths().maxProduct(words));

        words = new String[]{"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(new MaximumProductOfWordLengths().maxProduct(words));

        words = new String[]{"a","aa","aaa","aaaa"};
        System.out.println(new MaximumProductOfWordLengths().maxProduct(words));
    }
}
