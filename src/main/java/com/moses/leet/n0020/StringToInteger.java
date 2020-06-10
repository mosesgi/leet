package com.moses.leet.n0020;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public int myAtoi(String str) {
        str = str.trim();
        int mult = 1;
        boolean signFound = false;
        boolean firstDigit = true;
        int res =0;
        for(char c : str.toCharArray()){
            if(c=='+'){
                if(signFound){
                    break;
                }else{
                    signFound = true;
                }
            }else if(c=='-'){
                if(signFound){
                    break;
                }else{
                    signFound = true;
                    mult = -1;
                }
            }else if(Character.isDigit(c)){
                if(firstDigit){
                    firstDigit = false;
                    signFound = true;
                    res = c-'0';
                    res*=mult;
                }else{
                    int tmp = mult==1?res*10 + (c-'0') : res*10 - (c-'0');
                    if(mult==1 && (tmp<0 || (tmp - (c-'0')) / 10 != res)){
                        return Integer.MAX_VALUE;
                    }else if(mult==-1 && (tmp>0 || (tmp+(c-'0'))/10 != res)){
                        return Integer.MIN_VALUE;
                    }
                    res = tmp;
                }
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("-2147483649"));
        System.out.println(new StringToInteger().myAtoi("2147483648"));
        System.out.println(new StringToInteger().myAtoi("+-2"));
        System.out.println(new StringToInteger().myAtoi("    -42"));
        System.out.println(new StringToInteger().myAtoi("4193 with words"));
        System.out.println(new StringToInteger().myAtoi("words and 987"));
        System.out.println(new StringToInteger().myAtoi("-91283472332"));
        System.out.println(new StringToInteger().myAtoi("    -42"));

    }

    public int myAtoi1(String str){
        str = str.trim();
        int res = 0;
        int mult = 1;
        boolean signRead = false;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '-'){
                if(signRead){
                    break;
                }else{
                    mult = -1;
                    signRead = true;
                }
            }else if(str.charAt(i) == '+'){
                if(signRead){
                    break;
                }else{
                    mult = 1;
                    signRead = true;
                }
            }else if(Character.isDigit(str.charAt(i))){
                signRead = true;
                int dig =  (str.charAt(i) - '0');
                int tmp = res;
                res = res * 10 +dig;
                if(res < 0||(res - dig)/10 != tmp){
                    return mult==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        return res*mult;
    }

    public int myAtoiInitial(String str){
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


}
