package com.moses.leet.n0080;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class SqrtX {
    public int mySqrt(int x){
        if(x==1 || x==0){
            return x;
        }
        int low = 1; int high = x/2;
        if(x/high == high){
            return high;
        }
        while(low<high){
            int middle = (low+high)/2;
            if(low == high-1){
                return low;
            }
            if(x/middle == middle){
                return middle;
            }else if(x/middle > middle){
                low = middle;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(4));
        System.out.println(new SqrtX().mySqrt(8));
        System.out.println(new SqrtX().mySqrt(17));
        System.out.println(new SqrtX().mySqrt(28));
        System.out.println(new SqrtX().mySqrt(412341241));
        System.out.println(new SqrtX().mySqrt(2147483647));
    }

    // too slow
    public int mySqrtSlow(int x){
        if(x==1){
            return 1;
        }
        for(int i=0; i<=x/2; i++){
            long ii = (long)i;
            if(ii*ii==x){
                return (int)ii;
            } else if(ii*ii <x && (ii+1)*(ii+1) > x){
                return (int)ii;
            }
        }
        return x;
    }


}
