package com.moses.leet.n0520;

public class Base7 {
    public String convertToBase7(int num) {
        //100 -> 202
        //100/7 = 14 %2
        //13+1 = 14 /7 = 2  %0

        //-7 -> -10
        //-7/7  -> -1 %0
        if(num==0){
            return "0";
        }
        boolean isPos = num>=0;
        StringBuilder sb = new StringBuilder();
        num = Math.abs(num);
        while(num > 0){
            sb.insert(0, num%7);
            num = num/7;
        }
        if(!isPos){
            sb.insert(0, "-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(100));
        System.out.println(new Base7().convertToBase7(-7));
    }
}
