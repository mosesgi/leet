package com.moses.leet.n0640;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int p = (int)Math.sqrt(c);
        if(p*p == c){
            return true;
        }
        int mid = p+1;
        for(int i=mid; i>=0; i--){
            int left = c - i*i;
            if(left < 0){
                continue;
            }
            int half = (int)Math.sqrt(left);
            if(half * half == left){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(10000000));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(11));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(5));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(3));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(2));
    }
}
