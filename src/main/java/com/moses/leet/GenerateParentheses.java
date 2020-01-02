package com.moses.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/solution/
 */
public class GenerateParentheses {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
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
