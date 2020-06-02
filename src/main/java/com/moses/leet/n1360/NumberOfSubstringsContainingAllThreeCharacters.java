package com.moses.leet.n1360;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        //aaabbbbcccc
        int[] cnt = new int[3];
        int i=0;
        int j=0;
        int res = 0;
        while(j<s.length()){
            cnt[s.charAt(j)-'a']++;
            if(qualify(cnt)){
                while(i<j){
                    cnt[s.charAt(i)-'a']--;
                    if(!qualify(cnt)){
                        cnt[s.charAt(i)-'a']++;
                        res+= i+1;
                        break;
                    }
                    i++;
                }
            }
            j++;
        }
        return res;
    }

    boolean qualify(int[] cnt){
        return cnt[0] >0 && cnt[1] >0 && cnt[2] > 0;
    }
}
