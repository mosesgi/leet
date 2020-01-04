package com.moses.leet.n0020;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char latest = ' ';
        for(Character c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            if(c == ')' || c=='}' || c==']'){
                if(stack.size() == 0) return false;
                if(c == ')' && stack.pop() != '('){
                    return false;
                }
                if(c == '}' && stack.pop() != '{'){
                    return false;
                }
                if(c == ']' && stack.pop() != '['){
                    return false;
                }
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        String input = "()";
        ValidParentheses va = new ValidParentheses();
        System.out.println(va.isValid(input));

        input = "()[]{}";
        System.out.println(va.isValid(input));

        input = "(]";
        System.out.println(va.isValid(input));

        input = "([)]";
        System.out.println(va.isValid(input));

        input = "{[]}";
        System.out.println(va.isValid(input));
    }
}
