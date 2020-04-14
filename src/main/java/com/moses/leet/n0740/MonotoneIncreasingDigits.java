package com.moses.leet.n0740;

public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        if(N<10){
            return N;
        }
        String s = N+"";
        int equalPos = -1;
        int decPos = -1;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i+1) < s.charAt(i)){
                decPos = i;
                break;
            }else if(s.charAt(i+1) == s.charAt(i)){
                if(equalPos == -1){
                    equalPos = i;
                }
            }else{  //increasing
                equalPos = -1;
            }
        }

        if(decPos == -1){
            return N;
        }
        if(equalPos != -1){
            decPos = equalPos;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<decPos; i++){
            sb.append(s.charAt(i));
        }
        int followUp = decPos;
        if(s.charAt(decPos) > '1') {
            sb.append((char) (s.charAt(decPos) - 1));
        }else {
            sb.append('9');
            followUp++;
        }
        for(int i=followUp+1; i<s.length(); i++){
            sb.append('9');
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(7774));
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(10));
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(1234));
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(332));
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(3457773));
    }
}
