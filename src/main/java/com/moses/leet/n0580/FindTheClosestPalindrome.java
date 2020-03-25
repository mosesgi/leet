package com.moses.leet.n0580;

import java.math.BigInteger;

public class FindTheClosestPalindrome {
    //7654890 -> 7654567(323), 7653567(1323), 7655567(677)
    //589043 -> 589985(942), 588885(158), 590095(1052)
    public String nearestPalindromic(String n) {
        Long origin = Long.parseLong(n);
        if(origin<=10){
            return String.valueOf(origin-1);
        }else if(origin == 11){
            return 9+"";
        }
        boolean isEven = n.length()%2 == 0;
        int mid = isEven? (n.length()-1)/2 : n.length()/2;
        String bs = n.substring(0, mid+1);

        Long b = Long.parseLong(bs);

        Long rst = origin;
        Long min = origin;
        for(int i=-1; i<=1; i++){
            Long p = b+i;
            String ps = p + "";
            boolean executeEven = false;
            if(isEven){
                if(ps.length() == bs.length() + 1){
                    executeEven = false;
                } else if(ps.length() == bs.length()-1){
                    executeEven = false;
                    ps = ps + "9";
                } else {
                    executeEven = true;
                }
            }else{
                if(ps.length() == bs.length() + 1){
                    executeEven = true;
                    ps = ps.substring(0, ps.length()-1);
                }else if(ps.length() == bs.length()-1){
                    executeEven = true;
                } else{
                    executeEven = false;
                }
            }
            if(executeEven){
                StringBuilder sps = new StringBuilder(ps);
                String append = sps.reverse().toString();
                p = Long.parseLong(ps + append);
                Long diff = Math.abs(p-origin);
                if(diff != 0 && diff < min){
                    min = Math.abs(p-origin);
                    rst = p;
                }
            }else{
                StringBuilder sps = new StringBuilder(ps);
                sps.setLength(sps.length()-1);
                p = Long.parseLong(ps + sps.reverse().toString());
                Long diff = Math.abs(p-origin);
                if(diff != 0 && diff < min){
                    min = Math.abs(p-origin);
                    rst = p;
                }
            }
        }

        return rst+"";
    }

    public static void main(String[] args) {
        //100000
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("10001"));
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("999"));
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("99"));
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("100"));
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("123"));
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("1"));
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("7654890"));
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("589043"));
        System.out.println(new FindTheClosestPalindrome().nearestPalindromic("580043"));
    }
}
