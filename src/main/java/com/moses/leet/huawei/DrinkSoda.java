package com.moses.leet.huawei;

import java.util.Scanner;

public class DrinkSoda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            int num = Integer.parseInt(str);
            if(num == 0){
                break;
            }
            int res = 0;
            while(num >= 3){
                int tmp = num/3;
                res += tmp;
                num = tmp + num%3;
            }
            if(num == 2){
                res++;
            }
            System.out.println(res);
        }
    }
}
