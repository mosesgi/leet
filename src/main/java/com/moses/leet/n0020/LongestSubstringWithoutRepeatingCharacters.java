package com.moses.leet.n0020;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l =0;
        int[] cnt = new int[256];
        for(int r = 0; r<s.length(); r++){
            int ch = s.charAt(r) - ' ';
            cnt[ch]++;
            while(cnt[ch]>1){
                cnt[s.charAt(l++)-' ']--;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        int len = 0;
        int left = 0, right=0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            char c = s.charAt(right);
            if(set.contains(c)){
                len = Math.max(len, right-left);
                while(left <=right){
                    char d = s.charAt(left++);
                    set.remove(d);
                    if(d == c){
                        break;
                    }
                }
            }
            right++;
            set.add(c);
        }
        len = Math.max(len, right-left);
        return len;
    }

    public int lengthOfLongestSubstringFirst(String s) {
        int longest = 0;

        for(int start = 0; start<s.length(); start++){
            Set<Character> set = new HashSet<>();
            int j = 0;
            inner: for(int i = start; i < s.length(); i++){
                set.add(s.charAt(i));
                if(i==s.length()-1){
                    if(s.length() - start >longest){
                        longest = s.length() - start;
                    }
                    break inner;
                }
                j=i+1;
                if(set.contains(s.charAt(j))){
                    if((j-start)>longest){
                        longest = j-start;
                    }
                    break inner;
                }
            }
        }

        return longest;
    }


    public int slidingWindow(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String test = "abcabcc";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(test));
    }

}
