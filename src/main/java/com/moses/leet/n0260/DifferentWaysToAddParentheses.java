package com.moses.leet.n0260;

import java.lang.reflect.Array;
import java.util.*;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
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
