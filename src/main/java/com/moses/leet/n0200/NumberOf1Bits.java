package com.moses.leet.n0200;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i=0; i<32; i++){
            int tmp = n|1;
            if(tmp == n){
                cnt++;
            }
            n>>=1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(11));
        System.out.println(new NumberOf1Bits().hammingWeight(128));
        System.out.println(new NumberOf1Bits().hammingWeight(-3));
    }
}
