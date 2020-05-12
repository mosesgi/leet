package com.moses.leet.n0260;

import java.lang.reflect.Array;
import java.util.*;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        int num = 0;
        for(char c : input.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }else{
                nums.add(num);
                ops.add(c);
                num = 0;
            }
        }
        nums.add(num);

        return dfs(nums, ops);
    }

    List<Integer> dfs(List<Integer> nums, List<Character> ops){
        List<Integer> list = new ArrayList<>();
        if(nums.size() == 1){
            list.add(nums.get(0));
            return list;
        }
        for(int i=0; i<ops.size(); i++){
            List<Integer> left = dfs(nums.subList(0, i+1), ops.subList(0, i));
            List<Integer> right = dfs(nums.subList(i+1, nums.size()), ops.subList(i+1, ops.size()));
            char o = ops.get(i);
            for(int l : left){
                for(int r:right){
                    list.add(calc(l, r, o));
                }
            }
        }
        return list;
    }

    int calc(int a, int b, char op){
        if(op == '+'){
            return a+b;
        }else if(op == '-'){
            return a-b;
        }else if(op == '*'){
            return a*b;
        }
        return 0;
    }



    public List<Integer> diffWaysToComputeOld(String input) {
        List<Integer> result = new ArrayList<>();
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")){
            result.add(Integer.parseInt(input));
            return result;
        }

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c == '-' || c=='*' || c=='+'){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(Integer l : left){
                    for(Integer r : right){
                        if(c=='-'){
                            result.add(l-r);
                        }else if(c=='+'){
                            result.add(l+r);
                        }else{
                            result.add(l*r);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input;
        input = "2-1-1";
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute(input));

        input = "2*3-4*5";
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute(input));
    }
}
