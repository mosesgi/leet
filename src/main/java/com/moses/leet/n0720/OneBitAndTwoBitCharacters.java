package com.moses.leet.n0720;

public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        //1110011110
        int cnt1 = 0;
        for(int i=bits.length-2; i>=0; i--){
            if(bits[i]==1){
                cnt1++;
            }else{
                break;
            }
        }
        return cnt1%2==0;
    }
}
