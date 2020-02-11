package com.moses.leet.n0200;

public class ReverseBits {
    public int reverseBits(int n){
        int rst = 0;

        for(int i=0; i<32; i++) {
            int end = n & 1;
            n >>= 1;
            rst = rst | end;
            if(i < 31) {
                rst <<= 1;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596));
        System.out.println(new ReverseBits().reverseBits(-3));
    }

}
