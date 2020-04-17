package com.moses.leet.n0800;

public class RotatedDigits {
    public int rotatedDigits(int N) {
        int res= 0;
        outer: for(int i=1; i<=N; i++){
            int good = 0;
            for(char c : (i+"").toCharArray()){
                if(c == '3' || c=='4' || c=='7'){
                    continue outer;
                }
                if(c=='2' || c=='5' || c=='6' || c=='9'){
                    good++;
                }
            }
            if(good>0){
                res++;
            }
        }
        return res;
    }
}
