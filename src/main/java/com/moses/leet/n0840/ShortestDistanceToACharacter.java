package com.moses.leet.n0840;

import java.util.TreeSet;

/**
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 *
 * Example 1:
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 *
 *
 * Note:
 *
 *     S string length is in [1, 10000].
 *     C is a single character, and guaranteed to be in string S.
 *     All letters in S and C are lowercase.
 *
 */
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        TreeSet<Integer> pos = new TreeSet<>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == C){
                pos.add(i);
            }
        }
        int[] res = new int[S.length()];
        for(int i=0; i<S.length(); i++){
            Integer left = pos.floor(i);
            Integer right = pos.ceiling(i);
            if(left == null){
                res[i] = right-i;
            }else if(right == null){
                res[i] = i-left;
            }else{
                res[i] = Math.min(right-i, i-left);
            }
        }
        return res;
    }
}
