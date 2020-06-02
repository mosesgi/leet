package com.moses.leet.n1020;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int tmp = 0;
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            tmp<<=1;
            tmp |= A[i];
            tmp%=5;
            res.add(tmp % 5 == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i=0; i<500; i++){
            if(i%5==0){
                System.out.println("i:"+ i +", b:" + Integer.toBinaryString(i));
            }
        }
    }

}
