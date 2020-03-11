package com.moses.leet.n0440;

public class NumberOfSegmentsInString {
    public int countSegments(String s) {
        if(s== null || s.length() == 0){
            return 0;
        }
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            while(i<s.length() && s.charAt(i) == ' '){
                i++;
            }
            if(i == s.length()){
                break;
            }
            while(i<s.length() && s.charAt(i) != ' '){
                i++;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s;
        s = "Hello,   my  name is John abc   ";
        System.out.println(new NumberOfSegmentsInString().countSegments(s));
    }
}
