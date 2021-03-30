package com.moses.leet.n0380;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l=1, r = num;
        while(l<=r){
            int m = l+(r-l)/2;
            if(num%m==0 && m == num/m){
                return true;
            }else if(m < num/m){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare1(int num) {
        if(num == 1){
            return true;
        }
        long l=1L, r = num/2L;
        while(l <= r){
            long m = l+(r-l)/2;
            long tmp = m*m;
            if(tmp == num){
                return true;
            }else if(tmp < num){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(681));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(808201));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(14));
    }
}
