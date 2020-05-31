package com.moses.leet.n1420;

public class Thek_thLexicographicalStringOfAllHappyStringsOfLengthN {

    public String getHappyString(int n, int k) {
        int start = 0;
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        int level = n-1;
        Character prev = null;
        while(pos < n) {
            char[] chars;
            if(prev == null){
                chars = new char[]{'a', 'b', 'c'};
            }else if(prev == 'a'){
                chars = new char[]{'b', 'c'};
            }else if(prev == 'b'){
                chars = new char[]{'a', 'c'};
            }else{
                chars = new char[]{'a', 'b'};
            }
            int charIdx = 0;
            while (start + Math.pow(2, level) < k) {
                start += Math.pow(2, level);
                charIdx++;
            }
            if(charIdx >= chars.length){
                return "";
            }
            pos++;
            level--;
            prev = chars[charIdx];
            sb.append(prev);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Thek_thLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(10, 100));
        System.out.println(new Thek_thLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(1, 3));
        System.out.println(new Thek_thLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(1, 4));
        System.out.println(new Thek_thLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(3,9));
    }
}

