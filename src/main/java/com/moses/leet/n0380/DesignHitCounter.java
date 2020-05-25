package com.moses.leet.n0380;

import java.util.*;

public class DesignHitCounter {
    class HitCounter {
        int sum= 0;
        List<Integer> times = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        /** Initialize your data structure here. */
        public HitCounter() {

        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            sum++;
            if(times.size() == 0){
                times.add(timestamp);
                counts.add(sum);
            }else{
                int last = times.get(times.size()-1);
                if(last == timestamp){
                    counts.set(counts.size()-1, sum);
                }else{
                    counts.add(sum);
                    times.add(timestamp);
                }
            }
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            int right = Collections.binarySearch(times, timestamp);
            right = right<0?-right -2 :right;
            if(right < 0){
                return 0;
            }
            if(timestamp > 300) {
                int left = Collections.binarySearch(times, timestamp - 300);
                left = left < 0? -left-2:left;
                if(left < 0){
                    return counts.get(right);
                }
                return counts.get(right) -counts.get(left);
            }else{
                return counts.get(right);
            }
        }
    }
}
