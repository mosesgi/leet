package com.moses.leet;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 */
public class ReverseInteger {
    public int reverse(int x){
        boolean isNeg = x<0;
        if(isNeg) x = -1*x;
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        int y = 0;
        try{
            y=Integer.parseInt(sb.toString());
        } catch(Exception e){

        }
        if(isNeg) y = -1*y;
        return y;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1646324359));
    }
}
