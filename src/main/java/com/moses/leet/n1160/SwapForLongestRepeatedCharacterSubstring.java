package com.moses.leet.n1160;

public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        int l = 0, r = 0;
        int maxLen =0;
        while(r < text.length()){
            int nextL = l;
            while(r+1 < text.length() && text.charAt(r+1) == text.charAt(r)){
                r++;
            }
            r++;
            nextL = r;
            maxLen = Math.max(maxLen, r-l);
            //find one to swap
            //from head
            boolean headFound = false;
            for(int i=0; i<l; i++){
                if(text.charAt(i) == text.charAt(l)){
                    headFound = true;
                    break;
                }
            }
            if(headFound) {

                while (r + 1 < text.length() && text.charAt(r + 1) == text.charAt(l)) {
                    r++;
                }
                maxLen = Math.max(maxLen, r-l+1);
            }

            //from tail
            if(!headFound){
                boolean tailFound = false;
                int tailPos = -1;
                for(int i=text.length()-1; i>r; i--){
                    if(text.charAt(i) == text.charAt(l)){
                        tailFound = true;
                        tailPos = i;
                        break;
                    }
                }
                if(tailFound) {
                    while (r + 1 < tailPos && text.charAt(r + 1) == text.charAt(l)) {
                        r++;
                    }
                    maxLen = Math.max(maxLen, r-l+1);
                }
            }

            l = nextL;
            r = l;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String text;
        text = "aaabaaa";
        System.out.println(new SwapForLongestRepeatedCharacterSubstring().maxRepOpt1(text));
        text = "ababa";
        System.out.println(new SwapForLongestRepeatedCharacterSubstring().maxRepOpt1(text));
    }
}
