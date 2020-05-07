package com.moses.leet.n0220;

import java.util.Arrays;

public class BitwiseAndOfNumbersRange {

    //best solution. Find same prefix
    public int rangeBitwiseAnd(int m, int n) {
        int pos = 0;
        while(m!=n){
            m>>=1;
            n>>=1;
            pos++;
        }
        return m<<pos;
    }

    //my own way
    public int rangeBitwiseAndMine(int m, int n) {
        if(m==n){
            return m;
        }
        int[] rst = new int[32];

        int bitM = m; int bitN = n;
        outer: for(int i=31; i>=0; i--){
            int tmpM = bitM;
            int tmpN = bitN;
            while(tmpM <= tmpN) {
                boolean mIs1 = false;
                if ((tmpM & 1) == 1) {
                    mIs1 = true;
                }
                boolean nIs1 = false;
                if((tmpN & 1) == 1){
                    nIs1 = true;
                }
                if(mIs1 && nIs1){
                    tmpM++;
                    tmpN--;
                }else{
                    rst[i] = 0;
                    bitM >>=1;
                    bitN >>=1;
                    continue outer;
                }
            }
            rst[i] = 1;
            bitM >>= 1;
            bitN >>= 1;
        }

        System.out.println(Arrays.toString(rst));
        int rstI = 0;
        for(int i=0; i<32; i++){
            rstI = rstI | (rst[i] & 1);
            if(i < 31) {
                rstI <<= 1;
            }
        }
        return rstI;
    }

    public static void main(String[] args) {
        // 000000000000
        // 000000000001
        // 000000000010
        // 000000000011
        // 000000000100
        // 000000000101
        // 000000000110
        // 000000000111
        // 000000001000     8
        // 000000001001
        // 000000001010
        // 000000001011
        // 000000001100     12
        // 000000001101
        // 000000001110
        // 000000001111     15

        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(5,7));
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(0,1));
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(0,1));
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(8,15));
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(3,2147483647));
    }
}
