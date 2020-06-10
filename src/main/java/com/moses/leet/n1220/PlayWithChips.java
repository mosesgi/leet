package com.moses.leet.n1220;

public class PlayWithChips {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even =0;
        for(int i : chips){
            if(i%2==0){
                even++;
            }else{
                odd++;
            }
        }
        return Math.min(odd,even);
    }
}
