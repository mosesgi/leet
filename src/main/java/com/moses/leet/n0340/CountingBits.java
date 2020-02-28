package com.moses.leet.n0340;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        int[] simple = new int[]{0,1,1,2};
        if(num <= 3){
            return Arrays.copyOf(simple, num+1);
        }
        int[] rst = new int[num+1];
        int maxPos = 2;
        int currRef = 0;
        for(int i=0; i<=num; i++){
            if(i<=3){
                rst[i] = simple[i];
                continue;
            }
            rst[i] = rst[currRef++] + 1;
            if(rst[i] == maxPos+1){
                maxPos++;
                currRef = 0;
            }
        }
        return rst;
    }


    public int[] countBitsTrivial(int num) {
        int[] rst = new int[num+1];
        for(int i=0; i<=num; i++){
            int cnt = 0;
            int tmp = i;
            for(int j=0; j<32; j++){
                if((tmp|1)==tmp){
                    cnt++;
                }
                tmp>>=1;
            }
            rst[i] = cnt;
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(2)));
        System.out.println(Arrays.toString(new CountingBits().countBits(5)));
        System.out.println(Arrays.toString(new CountingBits().countBits(100)));
    }
}
