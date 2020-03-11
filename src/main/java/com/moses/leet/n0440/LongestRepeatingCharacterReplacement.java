package com.moses.leet.n0440;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
    //sliding window
    public int characterReplacement(String s, int k){
        int left = 0;
        int[] cnts = new int[26];
        int maxCnt = 0, maxLen = 0;
        for(int right = 0; right<s.length(); right++){
            int expandLetterCnt = ++cnts[s.charAt(right)-'A'];
            maxCnt = Math.max(maxCnt, expandLetterCnt);
            if(right-left+1-maxCnt > k){
                cnts[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }


    //My slow complex solution
    public int characterReplacementMine(String s, int k) {
        if(s==null || s.length() == 0){
            return 0;
        }
        if(k>= s.length()){
            return s.length();
        }
        int[] maxSize = new int[26];
        Map<Character, List<Seg>> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            List<Seg> list = map.getOrDefault(c, new ArrayList<>());
            int start = i;
            while(i+1 < s.length() && s.charAt(i+1) == c){
                i++;
            }
            int end = i;
            list.add(new Seg(start, end, end-start+1, c));
            maxSize[c-'A'] = Math.max(maxSize[c-'A'], end-start+1);
            map.put(c, list);
        }

        Set<Character> keys = map.keySet();
        for(char c : keys){
            List<Seg> list = map.get(c);
            int max = 0;
            if(list.size()==1){
                max = list.get(0).len + k;
                if(max > s.length()){
                    max = s.length();
                }
            } else {
                max = findMax(list, k, s.length());
            }
            maxSize[c-'A'] = Math.max(maxSize[c-'A'],max);
        }
        int max = 0;
        for(int i=0; i<26; i++){
            max = Math.max(max, maxSize[i]);
        }
        return max;
    }

    private int findMax(List<Seg> list, int k, int strLen) {
        int max = 0;

        for(int i=0; i<list.size(); i++){
            int tmpK = k;
            Seg curr = list.get(i);
            if(i+1 >=list.size()){
                max = Math.max(k+curr.len, max);
                continue;
            }
            int sum = 0;
            int tmpI = i;
            boolean shouldAddLast = false;
            while(tmpI +1 <list.size()){
                sum += curr.len;
                Seg next = list.get(tmpI+1);
                int gap = next.start - curr.end -1;
                if(tmpK >= gap){
                    tmpK -= gap;
                    sum+= gap;
                    shouldAddLast = true;
                    curr = next;
                    tmpI++;
                } else {
                    sum += tmpK;
                    tmpK = 0;
                    shouldAddLast = false;
                    break;
                }
            }
            if(shouldAddLast){
                sum+= curr.len;
            }
            sum+=tmpK;
            max = Math.max(max, sum);
        }
        if(max > strLen){
            return strLen;
        }
        return max;
    }

    class Seg{
        int start;
        int end;
        int len;
        char ch;
        Seg(int start, int end, int len, char ch){
            this.start = start;
            this.end = end;
            this.len = len;
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        String s;
        int k;

        s="EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH";
        k=7;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));  //11

        s ="KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        k = 4;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));  //7

        s = "ABAA";
        k = 0;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));  //2

        s = "FJJLFJAIORUOQEEEFIEEEED";
        k = 2;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));  //9

        s = "ABAB";
        k = 2;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));  //4

        s = "AABABBA";
        k = 1;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));  //4

    }
}
