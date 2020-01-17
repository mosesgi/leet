package com.moses.leet.n0100;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return recursive(s1, s2, s3, 0,0,0);
    }

    //simple but time limit exceeded... :(
    private boolean recursive(String s1, String s2, String s3, int p1, int p2, int p3) {
        if(p3 == s3.length()){
            return true;
        }
        boolean b1 = false;
        if(p1<s1.length() && s3.charAt(p3) == s1.charAt(p1)){
            b1 = recursive(s1, s2, s3, p1+1, p2, p3+1);
        }

        boolean b2 = false;
        if(p2<s2.length() && s3.charAt(p3) == s2.charAt(p2)){
            b2 = recursive(s1, s2, s3, p1, p2+1, p3+1);
        }
        return b1 || b2;
    }


    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));

        s3 = "aadbbbaccc";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));

        s1 = "a";
        s2 = "b";
        s3 = "a";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));

        s1 = "accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa";
        s2 = "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb";
        s3 = "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));

    }
}
