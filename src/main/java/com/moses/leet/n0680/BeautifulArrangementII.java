package com.moses.leet.n0680;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangementII {
    //4, 2
    //1,3,2,4
    //5, 3
    //1,4,2,3,5
    //6, 5
    //1,6,2,5,3,4
    //5, 2
    //1,3,2,4,5
    public int[] constructArray(int n, int k) {
        Set<Integer> poss = new HashSet<>();
        for(int i=1; i<=n; i++){
            poss.add(i);
        }
        int[] ary = new int[n];
        int idx = 0;
        ary[idx] = 1;
        poss.remove(1);
        boolean isPos = true;
        for(int i=k; i>0; i--){
            int pos = isPos?ary[idx]+i:ary[idx]-i;
            if(poss.contains(pos) && pos <= n){
                ary[idx+1] = pos;
                idx++;
                poss.remove(ary[idx]);
            }else{
                ary[idx+1] = ary[idx]-i;
                idx++;
                poss.remove(ary[idx]);
            }
            isPos = !isPos;
        }
        while(idx != n-1){
            int curr = -1;
            for(int i : poss){
                if(Math.abs(i-ary[idx]) <= k){
                    curr = i;
                    ary[idx+1] = i;
                    idx++;
                }
            }
            poss.remove(curr);
        }
        return ary;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BeautifulArrangementII().constructArray(5,2)));
    }
}
