package com.moses.leet.n0020;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 */
public class ReverseInteger {
    public int reverse(int x){
        int res = 0;
        while(x != 0){
            int dig = x%10;
            x/=10;
            int tmp = res;
            res=res*10 + dig;
            if((res - dig)/10 != tmp){
                return 0;
            }
        }
        return res;
    }


    //using string is not good
    public int reverseUsingString(int x){
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
        System.out.println(new ReverseInteger().reverse(-322422));
        System.out.println(new ReverseInteger().reverse(1646324359));
    }
}
