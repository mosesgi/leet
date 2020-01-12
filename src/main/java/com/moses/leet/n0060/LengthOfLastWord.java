package com.moses.leet.n0060;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length()==0){
            return 0;
        }
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));

        s = "world";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));

        s = " ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));

        s = "Hello world    ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }
}
