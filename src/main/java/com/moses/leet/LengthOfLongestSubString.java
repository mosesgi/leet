package com.moses.leet;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
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
        String test = "abcde";
        System.out.println(new LengthOfLongestSubString().lengthOfLongestSubstring(test));
    }

}
