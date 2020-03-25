package com.moses.leet.n0560;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class NextGreaterElementIII {
    //55555, 5320
    //437973943  -> 437974339
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char prev = '0';
        int firstSmaller = -1;
        for(int i=s.length()-1; i>=0; i--){
            char cur = s.charAt(i);
            if(cur < prev){
                firstSmaller = i;
                break;
            }
            prev = cur;
        }
        if(firstSmaller == -1){
            return -1;
        }

        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i=firstSmaller+1; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char small = s.charAt(firstSmaller);
        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, firstSmaller);
        char change = map.higherKey(small);
        if(map.get(change) == 1){
            map.remove(change);
        }else{
            map.put(change, map.get(change) - 1);
        }
        map.put(small, map.getOrDefault(small, 0) + 1);

        sb.append(change);
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int cnt = entry.getValue();
            char key = entry.getKey();
            for(int i=0; i<cnt; i++){
                sb.append(key);
            }
        }
        Long value = Long.parseLong(sb.toString());
        if(value > Integer.MAX_VALUE){
            return -1;
        }else{
            return value.intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterElementIII().nextGreaterElement(12443322));
        System.out.println(new NextGreaterElementIII().nextGreaterElement(12));
        System.out.println(new NextGreaterElementIII().nextGreaterElement(21));
        System.out.println(new NextGreaterElementIII().nextGreaterElement(976432));
        System.out.println(new NextGreaterElementIII().nextGreaterElement(437973943));
    }
}
