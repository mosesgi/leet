package com.moses.leet.huawei;

import java.util.Scanner;

//立方根
public class MySquare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        double source = Double.parseDouble(input);
        double rst = getCubeRoot(source);

        long rstInt = Math.round(rst*10);
        System.out.println(rstInt/10d);
    }
    public static double getCubeRoot(double input){
        double left = 0, right = input/2;
        double rst = 0;
        while(left <= right){
            double m = left + (right-left)/2;
            double tmp = m*m*m;
            if(tmp == input){
                return m;
            }else if(tmp < input){
                rst = left;
                left = m+0.01;
            }else{
                right = m-0.01;
                rst = right;
            }
        }
        return rst;
    }

//    public static void main(String[] args) {
//        System.out.println(MySquare.getCubeRoot(11));
//    }
}
