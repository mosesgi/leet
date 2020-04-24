package com.moses.leet.n0080;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class SqrtX {
    public int mySqrt(int x){
        if(x<=1){
            return x;
        }
        int l=1, r = x, ans =0;
        while(l<=r){
            int m = l + (r-l)/2;
            if(m==x/m){
                return m;
            }else if(m < x/m){
                l = m+1;
                ans = m;        //keep biggest number which is less than sqrt(x)
            }else{
                r=m-1;
            }
        }
        return ans;
    }


    public int mySqrtOld(int x){
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
        System.out.println(new SqrtX().mySqrt(3));
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
