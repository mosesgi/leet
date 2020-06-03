package com.moses.leet.n0860;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 *
 *     () has score 1
 *     AB has score A + B, where A and B are balanced parentheses strings.
 *     (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 *
 * Example 1:
 *
 * Input: "()"
 * Output: 1
 *
 * Example 2:
 *
 * Input: "(())"
 * Output: 2
 *
 * Example 3:
 *
 * Input: "()()"
 * Output: 2
 *
 * Example 4:
 *
 * Input: "(()(()))"
 * Output: 6
 *
 *
 *
 * Note:
 *
 *     S is a eturn balanced parentheses string, containing only ( and ).
 *     2 <= S.length <= 50
 *
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        return daq(S, 0, S.length()-1);
    }

    int daq(String s, int l, int r){
        int res = 0;
        for(int i=l; i<=r; i++){
            int sum = 1;
            int j=i+1;
            while(sum != 0){
                sum += s.charAt(j++)=='('?1:-1;
            }
            if(j-i == 2){
                res +=1;
            }else{
                res += daq(s, i+1, j-2) * 2;
            }
            i = j-1;
        }
        return res;
    }
}
