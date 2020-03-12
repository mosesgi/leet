package com.moses.leet.n0460;

public class ArrangingCoins {
    public int arrangeCoins(int n){
        if(n==0){
            return 0;
        }
        long left = 1, right = n;
        while(left < right){
            long mid = left+(right-left)/2;
            long sumCoins = mid*(mid+1)/2;
            if(sumCoins > n){
                right = mid-1;
            }else if(sumCoins < n){
                left = mid+1;
            }else{
                return (int)mid;
            }
        }
        if(left*(left+1)/2 > n){
            return (int)left-1;
        }
        return (int)left;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(2));
        System.out.println(new ArrangingCoins().arrangeCoins(5));
        System.out.println(new ArrangingCoins().arrangeCoins(8));
    }
}
