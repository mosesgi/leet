package com.moses.leet.n0380;

import java.util.*;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 * Example:
 *
 * HitCounter counter = new HitCounter();
 *
 * // hit at timestamp 1.
 * counter.hit(1);
 *
 * // hit at timestamp 2.
 * counter.hit(2);
 *
 * // hit at timestamp 3.
 * counter.hit(3);
 *
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 *
 * // hit at timestamp 300.
 * counter.hit(300);
 *
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 *
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 *
 * Follow up:
 * What if the number of hits per second could be very large? Does your design scale?
 *
 */
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



//class HitCounter {
//    int lastHit;
//    TreeMap<Integer, Integer> map;      // 记录某次敲击之前所有敲击总数
//
//    /** Initialize your data structure here. */
//    public HitCounter() {
//        lastHit = 0;
//        map = new TreeMap<>();
//    }
//
//    /** Record a hit.
//     @param timestamp - The current timestamp (in seconds granularity). */
//    public void hit(int timestamp) {
//        if (lastHit == 0) {
//            map.put(timestamp, 1);
//        } else {
//            map.put(timestamp, map.get(lastHit) + 1);
//        }
//
//        lastHit = timestamp;
//    }
//
//    /** Return the number of hits in the past 5 minutes.
//     @param timestamp - The current timestamp (in seconds granularity). */
//    public int getHits(int timestamp) {
//        if (lastHit == 0) {
//            return 0;
//        }
//
//        int startTimeStamp = timestamp - 300;
//        if (startTimeStamp <= 0) {
//            return map.get(lastHit);
//        }
//
//        Integer key = map.floorKey(startTimeStamp);
//        if (key == null) {
//            return map.get(lastHit);
//        }
//
//        return map.get(lastHit) - map.get(key);
//    }
//}
