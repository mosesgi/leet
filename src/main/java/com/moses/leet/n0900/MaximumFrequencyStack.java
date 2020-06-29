package com.moses.leet.n0900;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    class FreqStack {
        Map<Integer, Integer> keyToFreq;
        Map<Integer, Stack<Integer>> freqToKey;
        int maxFreq = 0;
        public FreqStack() {
            keyToFreq = new HashMap<>();
            freqToKey = new HashMap<>();
        }

        public void push(int x) {
            int freq = keyToFreq.getOrDefault(x, 0) + 1;
            if(freq > maxFreq){
                maxFreq = freq;
            }
            keyToFreq.put(x, freq);
            freqToKey.computeIfAbsent(freq, z -> new Stack<>()).push(x);
        }

        public int pop() {
            int key = freqToKey.get(maxFreq).pop();
            keyToFreq.put(key, keyToFreq.get(key) - 1);
            if(freqToKey.get(maxFreq).isEmpty()){
                maxFreq--;
            }
            return key;
        }
    }
}
