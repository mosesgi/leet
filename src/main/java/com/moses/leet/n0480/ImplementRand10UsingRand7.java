package com.moses.leet.n0480;

import java.util.Random;

public class ImplementRand10UsingRand7 {
    public int rand10() {
        //7*7 matrix, 0~48, use 0~39 out of it.
        while(true) {
            int a = rand7()-1;
            int b = rand7()-1;
            int tmp = a*7 + b;
            if(tmp>=40){
                continue;
            }
            return tmp%10+1;
        }
    }


    public int rand7(){
        Random random = new Random();
        return random.nextInt(7);
    }
}
