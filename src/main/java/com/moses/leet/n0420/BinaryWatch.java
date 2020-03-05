package com.moses.leet.n0420;

import java.util.*;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<Integer> hLeds = new ArrayList<>();
        hLeds.addAll(Arrays.asList(1,2,4,8));
        List<Integer> mLeds = new ArrayList<>();
        mLeds.addAll(Arrays.asList(1,2,4,8,16,32));

        List<String> results = new ArrayList<>();
        for(int i=0; i<=num; i++){
            List<Integer> hRsts = new ArrayList<>();
            List<Integer> mRsts = new ArrayList<>();

            int hourNum = i;
            int minNum = num-i;
            hRsts = recursive(hourNum, hLeds, 0, 11);
            mRsts = recursive(minNum, mLeds, 0, 59);

            for(Integer h : hRsts){
                for(Integer m : mRsts){
                    String min = m<10?"0"+m:""+m;
                    results.add(h+":"+min);
                }
            }
        }
        return results;
    }

    private List<Integer> recursive(int hmNum, List<Integer> hmLeds, int startPos, int max) {
        if(hmNum == 0){
            return Arrays.asList(0);
        }
        List<Integer> curr = new ArrayList<>();
        for(int i=startPos; i<hmLeds.size()-hmNum+1; i++){
            if(hmNum >= 1){
                List<Integer> nexts = recursive(hmNum-1, hmLeds, i+1, max);
                for(Integer n : nexts){
                    int rst = hmLeds.get(i) + n;
                    if(rst <= max) {
                        curr.add(rst);
                    }
                }
            }
        }
        return curr;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new BinaryWatch().readBinaryWatch(1).toArray()));
        System.out.println(Arrays.toString(new BinaryWatch().readBinaryWatch(2).toArray()));
        System.out.println(Arrays.toString(new BinaryWatch().readBinaryWatch(3).toArray()));
    }
}
