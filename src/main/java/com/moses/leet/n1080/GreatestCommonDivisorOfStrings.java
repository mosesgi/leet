package com.moses.leet.n1080;

import java.util.ArrayList;
import java.util.List;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        List<String> list = new ArrayList<>();

        String small, big;
        if(str1.length() <= str2.length()){
            small = str1;
            big = str2;
        }else{
            small = str2;
            big = str1;
        }

        list.add(small);
        int sLen = small.length();
        int bLen = big.length();
        for(int i=small.length()/2; i>0; i--){
            if(sLen % i != 0 || bLen %i != 0){
                continue;
            }
            String can = small.substring(0, i);
            if(verify(can, small)){
                list.add(can);
            }
        }
        for(String can : list){
            if(verify(can, big)){
                return can;
            }
        }
        return "";
    }

    boolean verify(String cand, String source){
        StringBuilder sb = new StringBuilder(cand);
        while(sb.length() <source.length()){
            sb.append(cand);
        }
        return sb.toString().equals(source);
    }
}
