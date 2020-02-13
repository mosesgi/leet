package com.moses.leet.n0220;

public class ShortestPalindrome {
    public String shortestPalindrome(String s){
        int min = 0;
        int len = s.length();
        int right = len/2;
        while(right>=0){
            int tmp = isPalindrome(s, right);
            if(tmp != -1){
                min = tmp;
                break;
            }
            right--;
        }

        String prefix = "";
        for(int i=min+1; i<s.length(); i++){
            prefix = s.charAt(i) + prefix;
        }
        return prefix + s;
    }

    private int isPalindrome(String s, int mid){
        int tmp = -1;
        int start = mid+1;
        for(int i=mid; i>=0; i--){
            if(start>=s.length()){
                break;
            }
            if(s.charAt(i) == s.charAt(start)){
                if(i==0){
                    tmp = start;
                }
                start++;
            } else {
                break;
            }
        }
        start = mid+2;
        for(int i=mid; i>=0; i--){
            if(start>=s.length()){
                break;
            }
            if(s.charAt(i) == s.charAt(start)){
                if(i==0 && start > tmp){
                    tmp = start;
                }
                start++;
            } else {
                break;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome("abaab"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("abcd"));
    }
}
