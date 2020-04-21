package com.moses.leet.n0820;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String w : words){
            if(compare(S, w, 0, 0)){
                res++;
            }
        }
        return res;
    }

    boolean compare(String S, String w, int si, int wi){
        if(si == S.length() && wi == w.length()){
            return true;
        }else if(si == S.length() && wi!= w.length()){
            return false;
        }else if(si != S.length() && wi==w.length()){
            return false;
        }
        char wCh = w.charAt(wi);
        char sCh = S.charAt(si);
        if(wCh != sCh){
            return false;
        }
        int nextS = si+1;
        while(nextS < S.length() && S.charAt(nextS) == S.charAt(si)){
            nextS++;
        }
        if(nextS - si == 1){
            return compare(S, w, si+1, wi+1);
        }else if(nextS - si < 3){
            int size = nextS - si;
            for(int i=1; i<size; i++){
                if(wi+i >=w.length() || w.charAt(wi+i) != S.charAt(si+i)){
                    return false;
                }
            }
            return compare(S, w, nextS, wi+size);
        }else{
            int size = nextS - si;
            int nextW = wi+1;
            while(nextW < w.length() && w.charAt(nextW) == w.charAt(wi)){
                nextW++;
            }
            if(size == nextW - wi){
                return compare(S, w, nextS, nextW);
            }else if(size - (nextW-wi) < 0){
                return false;
            }else {
                return compare(S, w, nextS, nextW);
            }
        }
    }

    public static void main(String[] args) {
        String[] words;
        String S;
        words = new String[]{"hello", "hi", "helo"};
        S="heeellooo";
        System.out.println(new ExpressiveWords().expressiveWords(S, words));
    }
}
