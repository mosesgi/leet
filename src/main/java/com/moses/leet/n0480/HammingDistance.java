package com.moses.leet.n0480;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int rst = x^y;
        int cnt = 0;
        System.out.println(Integer.toBinaryString(rst));
        for(int i=0; i<32; i++){
            if((rst|1) == rst){
                cnt++;
            }
            rst>>>=1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1,4));
    }
}
