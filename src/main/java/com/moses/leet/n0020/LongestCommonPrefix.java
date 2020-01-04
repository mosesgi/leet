package com.moses.leet.n0020;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        int curr = 0; int maxLength = 1000;
        outer: while(curr <maxLength){
            char ch = ' ';
            for(int i=0; i<strs.length; i++){
                if(strs[i].length() < curr +1){
                    break outer;
                }
                if(i==0){
                    ch = strs[i].charAt(curr);
                } else if(ch != strs[i].charAt(curr)){
                    break outer;
                }
            }
            curr++;
        }
        return strs[0].substring(0, curr);
    }

    public static void main(String[] args) {
        LongestCommonPrefix lg = new LongestCommonPrefix();
        System.out.println(lg.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(lg.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(lg.longestCommonPrefix(new String[]{"aa", "a"}));

    }
}
