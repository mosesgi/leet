package com.moses.leet.n0400;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for(char c : t.toCharArray()){
            int ind = c-'a';
            cnt[ind]++;
        }

        for(char c : s.toCharArray()){
            int ind = c-'a';
            cnt[ind]--;
        }
        for(int i=0; i<cnt.length; i++){
            if(cnt[i] == 1){
                return (char)('a'+i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s, t;
        s = "abcd";
        t = "abcde";
        System.out.println(new FindTheDifference().findTheDifference(s, t));
    }
}
