package com.moses.leet.study;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class Test {

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        int[] s1Cnt = new int[26];
        for(char c : s1.toCharArray()){
            s1Cnt[c-'a']++;
        }

        int[] s2Cnt = new int[26];
        for(int i=0; i<s1.length(); i++){
            s2Cnt[s2.charAt(i)-'a']++;
        }
        if(match(s1Cnt, s2Cnt)){
            return true;
        }
        for(int i=0; i<s2.length()-s1.length(); i++){
            s2Cnt[s2.charAt(i+s1.length())-'a']++;
            s2Cnt[s2.charAt(i)-'a']--;
            if(match(s1Cnt, s2Cnt)){
                return true;
            }
        }
        return false;
    }

    boolean match(int[] cnt1, int[] cnt2){
        for(int i=0; i<cnt1.length; i++){
            if(cnt1[i]!= cnt2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
