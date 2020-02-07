package com.moses.leet.n0160;

import java.util.Stack;

public class EvalReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int rst = 0;
        for(String s : tokens){
            if("+".equals(s)){
                rst = stack.push(stack.pop()+stack.pop());
            } else if("-".equals(s)){
                int b = stack.pop();
                int a = stack.pop();
                rst = stack.push(a-b);
            } else if("*".equals(s)){
                rst = stack.push(stack.pop()*stack.pop());
            } else if("/".equals(s)){
                int b = stack.pop();
                int a = stack.pop();
                rst = stack.push(a/b);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return rst;
    }

    public static void main(String[] args) {

    }
}
