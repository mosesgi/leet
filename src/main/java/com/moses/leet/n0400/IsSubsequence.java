package com.moses.leet.n0400;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int sPos = 0;
        for(int i=0; i<t.length(); i++){
            if(s.charAt(sPos) == t.charAt(i)){
                sPos++;
            }
            if(sPos == s.length()){
                return true;
            }
        }
        return false;
    }

    public boolean isSubsequence1(String s, String t) {
        int pos = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int found = t.indexOf(c, pos);
            if(found == -1){
                return false;
            }
            pos = found+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s, t;

        s = "acb";
        t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));

        s = "abc";
        t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));

        s = "axc";
        t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));

    }
}
