package com.moses.leet.n0600;

import java.util.Stack;

public class TagValidator {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        String firstTag = "";

        for(int i=0; i<code.length(); i++){
            if(code.startsWith("<![CDATA[", i)){
                if(i==0 || stack.isEmpty()){
                    return false;
                }
                int j= i+9;
                int idx = code.indexOf("]]>", j);
                if(idx < 0){
                    return false;
                }
                i = idx+2;      //for loop will add one more 1.
            }else if(code.startsWith("</", i)){
                if(i==0){
                    return false;
                }
                int j = i+2;
                int idx = code.indexOf(">", j);
                if(idx < 0 || idx==j || idx-j > 9){
                    return false;
                }

                for(int k = j; k<idx; k++){
                    if(!Character.isUpperCase(code.charAt(k))){
                        return false;
                    }
                }
                String s = code.substring(j, idx);
                if(idx == code.length()-1 && !s.equals(firstTag)){
                    return false;
                }
                i = idx;
                if(stack.isEmpty() || !stack.pop().equals(s)){
                    return false;
                }
            }else if(code.startsWith("<", i)){
                int j = i+1;
                int idx = code.indexOf(">", j);
                if(idx < 0 || idx == j || idx-j > 9){
                    return false;
                }
                for(int k = j; k<idx; k++){
                    if(!Character.isUpperCase(code.charAt(k))){
                        return false;
                    }
                }
                String s = code.substring(j, idx);
                if(i == 0){
                    firstTag = s;
                }
                i = idx;
                stack.push(s);
            }else{
                if(i==0 || stack.isEmpty()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
