package com.moses.leet.n0460;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gInd = g.length-1;
        int sInd = s.length-1;
        int cnt = 0;
        while(gInd >=0 && sInd >=0){
            if(s[sInd] >= g[gInd]){
                cnt++;
                sInd--;
                gInd--;
            }else{
                gInd--;
            }
        }
        return cnt;
    }
}
