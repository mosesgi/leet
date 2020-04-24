package com.moses.leet.n0060;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int start = s.length() -1, end = s.length() -1;
        boolean startFound = false, endFound = false;;
        for(int i=s.length() -1; i>=0; i--){
            if(!startFound){
                if(Character.isLetter(s.charAt(i))){
                    start = i;
                    startFound = true;
                }
            }else{
                if(s.charAt(i) == ' '){
                    end = i;
                    endFound = true;
                    break;
                }
            }
        }
        if(!startFound){
            return 0;
        }else if(endFound){
            return start - end;
        }else{
            return start+1;
        }
    }

    public int lengthOfLastWordOld(String s) {
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
