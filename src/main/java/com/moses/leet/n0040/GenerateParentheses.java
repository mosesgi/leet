package com.moses.leet.n0040;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/solution/
 */
public class GenerateParentheses {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, n);
        return result;
    }

    void backtrack(StringBuilder sb, int sum, int n){
        if(sum < 0 || sum > n){
            return;
        }
        if(sb.length() == 2*n){
            if(sum == 0){
                result.add(sb.toString());
            }
            return;
        }

        sb.append('(');
        backtrack(sb, sum+1, n);

        sb.setCharAt(sb.length()-1, ')');
        backtrack(sb, sum-1, n);

        sb.setLength(sb.length()-1);
    }



    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        rec(n, 0, new StringBuilder(), res);
        return res;
    }

    void rec(int n, int sum, StringBuilder s, List<String> res){
        if(s.length() == n*2){
            if(sum==0){
                res.add(s.toString());
            }
            return;
        }
        if(sum < 0 || sum > n){
            return;
        }
        s.append("(");
        rec(n, sum+1, s, res);
        s.setCharAt(s.length()-1, ')');
        rec(n, sum-1, s, res);
        s.setLength(s.length()-1);
    }




    List<String> list = new ArrayList<>();
    public List<String> generateParenthesisOld(int n) {
        int total = n*2;
        recurseGen("", total);

        return list;
    }
    private void recurseGen(String str, int remainChars) {
        if(remainChars == 0){
            if(isValid(str)){
                list.add(str);
            }
        } else {
            for(int i=0; i<2; i++){
                String tmp = str;
                if(i==0){
                    tmp += '(';
                } else {
                    tmp += ')';
                }
                recurseGen(tmp, remainChars -1);
            }
        }
    }
    private boolean isValid(String str){
        int result = 0;
        for(Character c:str.toCharArray()){
            if(c=='('){
                result++;
            } else if(c== ')'){
                result--;
            }
            if(result <0){
                return false;
            }
        }
        return result ==0;
    }


    public static void main(String[] args) {
        List<String> rst = new GenerateParentheses().generateParenthesis(3);
        for(String s: rst){
            System.out.println(s);
        }
    }
}
