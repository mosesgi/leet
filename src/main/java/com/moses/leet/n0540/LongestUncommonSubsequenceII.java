package com.moses.leet.n0540;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Set<Integer> dupSet = new HashSet<>();

        for(int i=strs.length-1; i>0; i--){
            if(dupSet.contains(i)){
                continue;
            }
            String a = strs[i];
            for(int j=i-1; j>=0; j--){
                String b = strs[j];
                if(a.equals(b)){
                    dupSet.add(i);
                    dupSet.add(j);
                }
            }
        }

        int max = -1;
        for(int i=0; i<strs.length; i++){
            if(dupSet.contains(i)){
                continue;
            }
            String curr = strs[i];
            int tmpMax = curr.length();
            for(Integer j : dupSet){
                if(curr.length() > strs[j].length()){
                    continue;
                }
                if(isSub(curr, strs[j])){
                    tmpMax = -1;
                    break;
                }
            }
            if(tmpMax != -1){
                max = Math.max(max, tmpMax);
            }
        }
        return max;
    }

    private boolean isSub(String curr, String str) {
        int curPos = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == curr.charAt(curPos)){
                curPos++;
            }
            if(curPos == curr.length()){
                return true;
            }
        }
        if(curPos != curr.length()){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        String[] strs;

        strs = new String[]{"aaa","aaa","aa"};
        System.out.println(new LongestUncommonSubsequenceII().findLUSlength(strs));

        strs = new String[]{"aba", "cdc", "eae"};
        System.out.println(new LongestUncommonSubsequenceII().findLUSlength(strs));
    }
}
