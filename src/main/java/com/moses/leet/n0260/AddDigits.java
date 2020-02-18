package com.moses.leet.n0260;

public class AddDigits {
    public int addDigits(int num) {
        if(num < 10){
            return num;
        }
        int tmp = 0;
        while(num > 0){
            tmp+=num%10;
            num/=10;
        }
        return addDigits(tmp);
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
        System.out.println(new AddDigits().addDigits(65356789));
    }
}
