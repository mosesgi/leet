package com.moses.leet.n0200;

/**
 * Given an input string , reverse the string word by word.
 *
 * Example:
 *
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * Note:
 *
 *     A word is defined as a sequence of non-space characters.
 *     The input string does not contain leading or trailing spaces.
 *     The words are always separated by a single space.
 *
 * Follow up: Could you do it in-place without allocating extra space?
 *
 */
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        int l=0, r = s.length - 1;
        while(l<r){
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }

        int prev = 0;
        for(int i=0; i<s.length; i++){
            if(s[i] == ' ' || i == s.length-1){
                int x = prev;
                int y = i==s.length-1?i:i-1;
                while(x<y){
                    char tmp = s[x];
                    s[x]= s[y];
                    s[y] = tmp;
                    x++;
                    y--;
                }
                prev = i+1;
            }
        }
    }
}
