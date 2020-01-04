package com.moses.leet.n0020;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public int myAtoi(String str){
        str = str.trim();
        if(str.length()==0){
            return 0;
        }
        int end = 0;
        int start = 0;
        boolean isNeg = false;
        if(str.charAt(0)=='-'){
            isNeg = true;
            start = 1;
        } else if(str.charAt(0) == '+'){
            start = 1;
        }
        for(int i=0; i<str.length(); i++){
            if(start==1 && i==0){
                continue;
            }
            if(!Character.isDigit(str.charAt(i))){
                end = i;
                break;
            }
            end=i+1;
        }

        if(end==0 || (end==1 && start==1)) return 0;
        String sb = str.substring(start, end);
        int result = 0;
        try{
            result = Integer.parseInt(sb);
        } catch (Exception e){
            result = !isNeg?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return isNeg?-1*result:result;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("+-2"));
        System.out.println(new StringToInteger().myAtoi("    -42"));
        System.out.println(new StringToInteger().myAtoi("4193 with words"));
        System.out.println(new StringToInteger().myAtoi("words and 987"));
        System.out.println(new StringToInteger().myAtoi("-91283472332"));
        System.out.println(new StringToInteger().myAtoi("    -42"));

    }
}
