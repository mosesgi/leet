package com.moses.leet.n1300;


public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while(n>0){
            int cur = n%10;
            product *=cur;
            sum+=cur;
            n/=10;
        }
        return product-sum;
    }
}
