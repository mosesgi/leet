package com.moses.leet.n0240;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s){
        Stack<String> stack = new Stack<>();
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' '){
                continue;
            }
            if(c == '('){
                stack.push(String.valueOf(c));
            } else if(c == ')'){
                if(sb.length() != 0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                int rst = calculateParenthesis(stack);
                stack.push(String.valueOf(rst));
            } else if(c == '+' || c=='-'){
                if(sb.length() != 0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                stack.push(String.valueOf(c));
            } else {
                sb.append(c);
                if(i==s.length()-1 && sb.length()!=0){
                    stack.push(sb.toString());
                }
            }
        }

        List<String> list = new ArrayList<>();
        while(!stack.isEmpty()){
            String str = stack.pop();
            list.add(0, str);
        }
        return calculateBasic(list);
    }

    private int calculateParenthesis(Stack<String> stack) {
        List<String> list = new ArrayList<>();
        while(!stack.isEmpty()){
            String s = stack.pop();
            if("(".equals(s)){
                break;
            }
            list.add(0, s);
        }
        return calculateBasic(list);
    }

    private int calculateBasic(List<String> list) {
        int prev = 0;
        for(int i=0; i<list.size(); i++){
            String s = list.get(i);
            if("+".equals(s) || "-".equals(s)){
                i++;
                int next = Integer.parseInt(list.get(i));
                if("+".equals(s)){
                    prev = prev + next;
                } else {
                    prev = prev - next;
                }
            } else {
                prev = Integer.parseInt(s);
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new BasicCalculator().calculate(" 2-1 + 2 "));
    }


}
