package com.moses.leet.n0100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    //DP solution.
    //For example, the String now is "123xxxx" and we know all the result from 2.
    //Because 12<26, we can make this string either"12"+"3xxxx" or 1+23xxxx which is exactly memo[n]=memo[n+1]+memo[n+2].
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if(s.startsWith("0")){
            return 0;
        }
        dp[0] = 1;
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);
            int prevTwo = Integer.parseInt(s.substring(i-1, i+1));
            if(c == '0'){
                if(prevTwo > 20 || prevTwo == 0){
                    return 0;
                }
                dp[i] = i-2<0?1:dp[i-2];
            }else{
                if(s.charAt(i-1) == '0'){
                    dp[i] = dp[i-1];
                }else{
                    if(prevTwo <= 26){
                        dp[i] = i-2<0?1:dp[i-2];
                    }
                    dp[i] += dp[i-1];
                }
            }
        }
        return dp[s.length()-1];
    }


    //my solution: divide and conquer +++ backtrack. similar efficiency with DP :) hahahahahahahaha!!!
    int count = 0;
    public int numDecodingsMine(String s) {
        if(s.length() == 0 || s.startsWith("0")){
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        return divide(s);
    }

    private int divide(String s){
        if(s.length()>10){
            int mid = s.length()/2;
            if(s.charAt(mid) < '3'){
                while(s.charAt(mid) < '3' && mid<s.length()-1){
                    mid++;
                }
            }
            if(mid+1 == s.length()){
                count=0;
                backtrack(s, 0);
                return count;
            }
            int int1 = divide(s.substring(0, mid+1));
            int int2 = divide(s.substring(mid+1));
            return int1*int2;
        } else {
            count=0;
            backtrack(s, 0);
            return count;
        }

    }

    private void backtrack(String s, int index) {
        if(index == s.length()-1 || index == s.length()){
            count++;
            return;
        }
        for(int i=1; i<=2; i++){
            if(i==2 && s.length() > index+2 && s.charAt(index+2) == '0'){
                continue;
            }
            if(i==1 && s.length() > index+1 && s.charAt(index+1) == '0'){
                continue;
            }
            if(i == 2 && s.charAt(index) > '2'){
                continue;
            }
            String sub = s.substring(index, index + i);
            int tmpInt = Integer.valueOf(sub);
            if(tmpInt > 26 ){
                continue;
            }
            backtrack(s, index + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));        //2  AB or L

        System.out.println(new DecodeWays().numDecodings("226"));       //3 "BZ" "VF or "BBF"

        System.out.println(new DecodeWays().numDecodings("223321"));

        System.out.println(new DecodeWays().numDecodings("30232001830284577018"));      //0
        System.out.println(new DecodeWays().numDecodings("57701"));      //0
        System.out.println(new DecodeWays().numDecodings("57201"));      //1


        System.out.println(new DecodeWays().numDecodings("520"));      //1
        System.out.println(new DecodeWays().numDecodings("502"));      //0
        System.out.println(new DecodeWays().numDecodings("022"));      //0

        System.out.println(new DecodeWays().numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));

        System.out.println(new DecodeWays().numDecodings("8435098221275814436356964965276761914618252012127634945951156398377952112951644342731746644843122125"));
    }
}
