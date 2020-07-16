package com.moses.leet.n0940;

import java.util.LinkedList;

public class NumberOfRecentCalls {
    class RecentCounter {
        LinkedList<Integer> list = new LinkedList<>();
        public RecentCounter() {

        }

        public int ping(int t) {
            list.offerLast(t);
            int old = t-3000;
            while(!list.isEmpty() && list.peekFirst() < old){
                list.pollFirst();
            }
            return list.size();
        }
    }
}
