package com.moses.leet.n0140;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartition {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==0){
            return list;
        }
        List<String> l = new ArrayList<>();
        recursive(s, 0, l);
        return list;
    }

    private void recursive(String s, int start, List<String> l) {
        if(start == s.length()){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=1; i<=s.length()-start; i++){
            String tmp = s.substring(start, start+i);
            if(isPalindrome(tmp)){
                l.add(tmp);
                recursive(s, start+i, l);
                l.remove(l.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        int left = 0; int right = chars.length-1;
        while(left<right){
            if(chars[left++] != chars[right--]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrintUtil.printNestedList(new PalindromePartition().partition("aababa"));
    }
}
