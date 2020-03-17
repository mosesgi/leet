package com.moses.leet.n0480;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueSubstringsInWraparoundString {

    public int findSubstringInWraproundString(String p) {
        //find longest length ends with character, and sum the total
        int[] cnt = new int[26];
        int currLen = 1;
        for(int i=0; i<p.length(); i++){
            while(i+1 < p.length() && (p.charAt(i+1) == p.charAt(i) + 1 || (p.charAt(i) == 'z' && p.charAt(i+1) == 'a'))){
                int index = p.charAt(i) - 'a';
                cnt[index] = Math.max(cnt[index], currLen);
                currLen++;
                i++;
            }
            int index = p.charAt(i) - 'a';
            cnt[index] = Math.max(cnt[index], currLen);
            currLen = 1;
        }

        int sum = 0;
        for(int i=0; i<26; i++){
            sum+= cnt[i];
        }
        return sum;
    }

    public int findSubstringInWraproundStringWrong(String p) {
        if(p.length() == 1){
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(int i=0; i<p.length(); i++){
            sb.append(p.charAt(i));
            while(i+1 < p.length() &&
                    (p.charAt(i+1) == p.charAt(i)+1 || (p.charAt(i)=='z' && p.charAt(i+1) == 'a'))){
                sb.append(p.charAt(i+1));
                i++;
            }
            combine(set, sb.toString());
            sb.setLength(0);
        }

        int sum = 0;
//        Set<String> finalSet = new HashSet<>();
        for(String s : set){
            int len = s.length();
            if(len <=26) {
                sum += (len + 1) * len / 2;
            }else {
                int ded = len-26;
                sum += (len+1)*len/2 - (ded+1)*ded/2;
            }
//            for(int i=s.length(); i>0; i--){
//                for(int j=0; j<s.length()-i+1; j++){
//                    finalSet.add(s.substring(j, j+i));
//                }
//            }
        }
        return sum;
    }

    private void combine(Set<String> set, String toString) {
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String curr = iter.next();
            if(curr.contains(toString)){
                return;
            }
            if(toString.contains(curr)){
                iter.remove();
            }
        }
        set.add(toString);
    }

    public static void main(String[] args) {
        //abcabcdehijklikl
        //abc...xyzabc...xyz...
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("cdefghefghijklmnopqrstuvwxmnijklmnopqrstuvbcdefghijklmnopqrstuvwabcddefghijklfghijklmabcdefghijklmnopqrstuvwxymnopqrstuvwxyz"));
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));

        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));

        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcde"));
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("abcabcdehijklikl"));
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("a"));
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("cac"));
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("zab"));

    }
}
