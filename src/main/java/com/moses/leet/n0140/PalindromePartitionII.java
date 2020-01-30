package com.moses.leet.n0140;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartitionII {
    Map<Integer, List<int[]>> cache = new HashMap<>();

    public int minCut(String s) {
        Map<int[], Integer> stepMap = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        int[] start = new int[]{0,0};
        q.offer(start);
        stepMap.put(start, 0);
        while(!q.isEmpty()){
            int[] pos = q.poll();
            List<int[]> nexts = findAllPalindromeFrom(s, pos[1]);
            for(int[] i : nexts){
                if(stepMap.containsKey(i)){
                    continue;
                }
                q.offer(i);
                stepMap.put(i, stepMap.get(pos) + 1);
                if(i[1] == s.length()){
                    return stepMap.get(pos);
                }
            }
        }
        return -1;
    }

    private List<int[]> findAllPalindromeFrom(String s, int pos){
        if(cache.containsKey(pos)){
            return cache.get(pos);
        }
        List<int[]> list = new ArrayList<>();
        for(int i=1; i<=s.length()-pos; i++){
            if(isPalindrome(s, pos, pos+i)){
                list.add(new int[]{pos, pos+i});
            }
        }
        cache.put(pos, list);
        return list;
    }

    private boolean isPalindrome(String s, int start, int end){
        end--;
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitionII().minCut("aababbab"));
        System.out.println(new PalindromePartitionII().minCut("aab"));
        System.out.println(new PalindromePartitionII().minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
    }
}
