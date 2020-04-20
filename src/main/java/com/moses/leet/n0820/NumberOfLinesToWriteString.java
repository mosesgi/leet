package com.moses.leet.n0820;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int start = 0;
        int line = 1;

        for(char c : S.toCharArray()){
            int a = widths[c-'a'];
            if(start + a > 100){
                start = a;
                line++;
            }else{
                start +=a;
            }
        }
        return new int[]{line, start};
    }
}
