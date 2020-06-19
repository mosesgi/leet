package com.moses.leet.n0580;

import java.util.*;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for(char c : s1.toCharArray()){
            cnt[c-'a']++;
        }
        int shouldMatch = 0;
        for(int i : cnt){
            if(i>0){
                shouldMatch++;
            }
        }
        int[] cnt2 = new int[26];
        int l = 0;
        int matched = 0;
        for(int r = 0; r<s2.length(); r++){
            char c = s2.charAt(r);
            cnt2[c-'a']++;
            if(cnt2[c-'a'] == cnt[c-'a']){
                matched++;
            }
            if(matched == shouldMatch) {
                while (l <= r && matched == shouldMatch) {
                    cnt2[s2.charAt(l) - 'a']--;
                    if (cnt2[s2.charAt(l) - 'a'] < cnt[s2.charAt(l) - 'a']) {
                        matched--;
                    }
                    l++;
                }
                if (r - l + 2 == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1, s2;
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));

        s1 = "adc";
        s2 = "dcda";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));
    }


    //aab, cdieabbbaaa
    public boolean checkInclusion1(String s1, String s2) {
        int[] cnt = new int[26];
        for(char c : s1.toCharArray()){
            cnt[c-'a']++;
        }

        int left = 0, right = 0;
        int[] tmp = new int[26];
        outer: while(right < s2.length()){
            char r = s2.charAt(right);
            if(cnt[r-'a'] == 0){
                right++;
                left = right;
                tmp = new int[26];
                continue;
            }
            tmp[r-'a']++;
            if(tmp[r-'a'] < cnt[r-'a']){
                right++;
                continue;
            }
            if(tmp[r-'a'] > cnt[r-'a']){
                char l = s2.charAt(left);
                while(tmp[r-'a'] > cnt[r-'a']){
                    left++;
                    tmp[l-'a']--;
                    l = s2.charAt(left);
                }
            }
            right++;
            for(int k=0; k<26; k++){
                if(cnt[k] != tmp[k]){
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }




    //O(N^2)
    public boolean checkInclusionON2(String s1, String s2) {
        int[] cnt = new int[26];
        for(char c : s1.toCharArray()){
            cnt[c-'a']++;
        }

        outer: for(int i=0; i<s2.length(); i++) {
            int[] tmpCnt = Arrays.copyOf(cnt, cnt.length);
            char c = s2.charAt(i);
            int k= i;
            while(tmpCnt[c-'a'] > 0){
                tmpCnt[c-'a']--;
                k++;
                if(k == s2.length()){
                    break;
                }
                c = s2.charAt(k);
            }
            for(int j=0; j<26; j++){
                if(tmpCnt[j] > 0){
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }


}
