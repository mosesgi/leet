package com.moses.leet.n0520;

public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if(num<=1)  return false;
        int half = (int)Math.sqrt(num);
        int sum = 1;
        for(int i=2; i<=half; i++){
            if(num%i == 0){
                sum += (i + num/i);
            }
        }
        return sum==num;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectNumber().checkPerfectNumber(323512124));
    }
}
