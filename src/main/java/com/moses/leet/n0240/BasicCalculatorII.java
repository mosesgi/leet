package com.moses.leet.n0240;

import java.util.*;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            if((!Character.isDigit(c) && ' ' !=c) || i==s.length()-1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                op = c;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate("3+2*2"));
        System.out.println(new BasicCalculatorII().calculate(" 3/2 "));
        System.out.println(new BasicCalculatorII().calculate(" 3+5 / 2 "));
    }


    public int calculateOld(String s) {
        List<String> list = new ArrayList<>();
        s = s.trim();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(' ' == c){
                continue;
            }
            if('+' == c || '-' == c || '*' == c || '/' == c){
                list.add(String.valueOf(c));
                continue;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(i)));
            while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                sb.append(s.charAt(i+1));
                i++;
            }
            list.add(sb.toString());
        }

        Deque<String> queue = new LinkedList<>();
        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            if("*".equals(str) || "/".equals(str)){
                String first = queue.pollLast();
                String next = list.get(i+1);
                i++;
                Integer fi = Integer.parseInt(first);
                Integer se = Integer.parseInt(next);
                if("*".equals(str)){
                    queue.addLast(String.valueOf(fi*se));
                } else {
                    queue.addLast(String.valueOf(fi/se));
                }
                continue;
            }
            queue.addLast(str);
        }

        int prev = 0;
        while(!queue.isEmpty()){
            String curr = queue.pollFirst();
            if("+".equals(curr) || "-".equals(curr)){
                Integer next = Integer.parseInt(queue.pollFirst());
                if("+".equals(curr)){
                    prev = prev + next;
                } else {
                    prev = prev - next;
                }
                continue;
            }
            prev = Integer.parseInt(curr);
        }

        return prev;
    }


}