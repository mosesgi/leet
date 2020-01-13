package com.moses.leet.n0080;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int promotion = 0;
        int bigLen = aChars.length > bChars.length? aChars.length : bChars.length;
        boolean aLength = bigLen == aChars.length;

        char[] rst = new char[bigLen];

        int j=aLength?bChars.length-1:aChars.length-1;
        for(int i=bigLen-1; i>=0; i--){
            int x= aLength? aChars[i]-'0':bChars[i]-'0';
            if(j>=0){
                x += aLength?bChars[j]-'0':aChars[j]-'0';
                j--;
            }
            x += promotion;

            if(x<2){
                rst[i] = x==0? '0':'1';
                promotion = 0;
            } else if(x==2) {
                rst[i] = '0';
                promotion = 1;
            } else {
                rst[i] = '1';
                promotion = 1;
            }
        }
        if(promotion ==1){
            return "1" + String.valueOf(rst);
        } else {
            return String.valueOf(rst);
        }
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1", "111"));       //100
        System.out.println(new AddBinary().addBinary("11", "1"));       //100
        System.out.println(new AddBinary().addBinary("1010", "1011"));  //10101
        System.out.println(new AddBinary().addBinary("1110", "1111"));      // 11101
    }
}
