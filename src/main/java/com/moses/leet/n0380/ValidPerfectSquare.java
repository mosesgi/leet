package com.moses.leet.n0380;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        int right = num/2;
        int left = 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int tmp = num/mid;
            if(tmp > mid){
                left = mid +1;
            } else if(tmp < mid){
                right = mid - 1;
            } else {
                if(num%mid == 0) {
                    return true;
                }else{
                    break;
                }
            }
        }
        if(left * left == num || right * right == num){
            return true;
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
