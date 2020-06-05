package com.moses.leet.n1200;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(new StringBuilder());
            }else if(c==')'){
                StringBuilder cur = stack.pop().reverse();
                stack.peek().append(cur);
            }else{
                stack.peek().append(c);
            }
        }
        return stack.pop().toString();
    }
}
