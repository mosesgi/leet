package com.moses.leet.n0060;

import java.math.BigInteger;

public class MultiplyStrings {

    public String multiply(String num1, String num2){
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        String rst = "0";

        for(int i = char2.length; i>0; i--){
            int posSecond = char2[i-1] - 48;

            StringBuilder sb = new StringBuilder();
            int promote = 0;
            for(int j = char1.length; j>0; j--){
                int posFirst = char1[j-1] - 48;

                int tmp = posSecond * posFirst + promote;
                String tmpStr = tmp+"";
                if(tmpStr.length() == 2) {
                    promote = tmpStr.charAt(0) - 48;
                    sb.insert(0, tmpStr.charAt(1));
                } else {
                    promote = 0;
                    sb.insert(0, tmpStr.charAt(0));
                }
            }
            if(promote != 0){
                sb.insert(0, promote);
            }

            for(int k = 0; k < char2.length -i; k++){
                sb.append('0');
            }
            System.out.println(sb.toString());
            rst = addBigNums(rst, sb.toString());
        }

        return "";
    }

    private String addBigNums(String num1, String num2){
        char[] char2 = num2.toCharArray();
        char[] char1 = num1.toCharArray();
        int posDif = char1.length - char2.length;
        for(int i = char2.length; i>0; i--){
            int posSec = char2[i-1] - 48;

        }
        return "";
    }

    public static void main(String[] args) {

        String num1 = "2", num2 = "3";
        System.out.println(new MultiplyStrings().multiply(num1, num2));

        num1 = "123"; num2 = "456";
        System.out.println(new MultiplyStrings().multiply(num1, num2));

        num1 = "999"; num2 = "99";
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}
