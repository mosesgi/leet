package com.moses.leet.n0660;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int cnt = s.length();
        for(int i=0; i<s.length(); i++){
            cnt += expand(s, i, 0);
            cnt += expand(s, i, 1);
        }
        return cnt;
    }

    private int expand(String s, int i, int odd) {
        int cnt = 0;
        if(odd == 1){       //odd
            int left = i-1;
            int right = i+1;
            while(left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
                cnt++;
                left--;
                right++;
            }
        }else{      //even (left has been visited)
            int left = i;
            int right = i+1;
            while(right < s.length() && left >=0 && s.charAt(left) == s.charAt(right)){
                cnt++;
                left--;
                right++;
            }
        }
        return cnt;
    }

    public int countSubstringsSlow(String s) {
        int cnt = s.length();
        for(int i=2; i<=s.length(); i++){
            for(int j=0; j<=s.length()-i; j++){
                int left = j;
                int right = i+j-1;
                if(isPalindrome(s, left, right)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s;
        s = "abc";
        System.out.println(new PalindromicSubstrings().countSubstrings(s));

        s = "aaa";
        System.out.println(new PalindromicSubstrings().countSubstrings(s));
    }
}
