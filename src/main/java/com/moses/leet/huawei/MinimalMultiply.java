package com.moses.leet.huawei;

import java.util.Scanner;

//最小公倍数
public class MinimalMultiply {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sa = scan.next();
        String sb = scan.next();
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        //18,24.        2,3,3; 2,2,2,3
        if(a==b){
            System.out.println(a);
        }else if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        for(int i=2; i<=b; i++){
            int poss = a*i;
            if(poss % b == 0){
                System.out.println(poss);
            }
        }
    }
}
