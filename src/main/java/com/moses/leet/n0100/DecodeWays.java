package com.moses.leet.n0100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    int count = 0;
    boolean isZero = false;
    public int numDecodings(String s) {
        if(s.length() == 0 || s.startsWith("0")){
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        backtrack(s, 0);

        return count;
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
    }
}
