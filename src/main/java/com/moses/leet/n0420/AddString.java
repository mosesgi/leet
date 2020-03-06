package com.moses.leet.n0420;

public class AddString {
    public String addStrings(String num1, String num2) {
        int remain = 0;
        int pos1 = num1.length()-1, pos2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        while(pos1>=0 || pos2>=0){
            int i1 = 0, i2 = 0;
            if(pos1>=0) {
                char c1 = num1.charAt(pos1);
                i1 = c1-'0';
            }
            if(pos2>=0) {
                char c2 = num2.charAt(pos2);
                i2 = c2 - '0';
            }
            int sum = i1+i2+remain;
            remain = sum/10;
            sb.insert(0, sum%10);
            pos1--;
            pos2--;
        }
        if(remain > 0){
            sb.insert(0, remain);
        }
        return sb.toString();
    }
}
