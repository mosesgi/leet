package com.moses.leet.n0700;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int cnt = 1;
        int prev = -1;
        int sum = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                cnt++;
            }else{
                if(prev != -1){
                    sum+= Math.min(prev, cnt);
                }
                prev = cnt;
                cnt = 1;
            }
        }
        if(prev != -1){
            sum+= Math.min(prev, cnt);
        }
        return sum;
    }
}
