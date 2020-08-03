package com.moses.leet.n0880;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 1;

        for(int i : piles){
            r = Math.max(r, i);
        }
        int pos = -1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(cal(piles, m) > H){
                l = m+1;
            }else{
                pos = m;
                r = m-1;
            }
        }
        return pos;
    }

    int cal(int[] piles, int cand){
        int res = 0;
        for(int i : piles){
            if(i%cand == 0){
                res += i/cand;
            }else{
                res += i/cand + 1;
            }
        }
        return res;
    }
}
