package com.moses.leet.n0360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStreamAsDisjointIntervals {
    //using TreeMap is better! Because remove(i) takes O(n) time. But mine is also right.
    class SummaryRanges {
        List<Pair> list = new ArrayList<>();
        /** Initialize your data structure here. */
        public SummaryRanges() {

        }

        public void addNum(int val) {
            if(list.size()==0){
                list.add(new Pair(val, val));
                return;
            }
            int left = 0, right = list.size()-1;
            if(left == right && val >= list.get(left).min && val <= list.get(left).max){
                return;
            }
            if(val < list.get(left).min -1){
                list.add(left, new Pair(val, val));
                return;
            } else if(val == list.get(left).min -1){
                list.get(left).min = val;
                return;
            } else if(val == list.get(right).max + 1){
                list.get(right).max = val;
                return;
            } else if(val > list.get(right).max +1){
                list.add(new Pair(val, val));
                return;
            }
            boolean exist = false;
            while(left < right - 1){
                int mid = (left+right)/2;
                Pair m = list.get(mid);
                if(val >= m.min && val <= m.max){
                    exist = true;
                    break;
                }else if(val < m.min){
                    right = mid;
                }else{
                    left = mid;
                }
            }
            if(exist){
                return;
            }
            if(val > list.get(left).max + 1 && val < list.get(right).min - 1) {
                list.add(right, new Pair(val, val));
            } else {
                if (val == list.get(left).max + 1) {
                    list.get(left).max = val;
                }
                if (val == list.get(right).min - 1) {
                    list.get(right).min = val;
                }
                if (list.get(left).max == val && list.get(right).min == val) {
                    list.get(left).max = list.get(right).max;
                    list.remove(right);
                }
            }
        }


        public int[][] getIntervals() {
            int[][] rst = new int[list.size()][2];
            for(int i=0; i<list.size(); i++){
                Pair p = list.get(i);
                rst[i] = new int[]{p.min, p.max};
            }
            return rst;
        }
    }

    class Pair {
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        SummaryRanges s = new DataStreamAsDisjointIntervals().new SummaryRanges();
        s.addNum(1);
        for(int[] i : s.getIntervals()){
            System.out.print(Arrays.toString(i) + ", ");
        }
        System.out.println();
        s.addNum(3);
        for(int[] i : s.getIntervals()){
            System.out.print(Arrays.toString(i) + ", ");
        }
        System.out.println();
        s.addNum(7);
        for(int[] i : s.getIntervals()){
            System.out.print(Arrays.toString(i) + ", ");
        }
        System.out.println();
        s.addNum(2);
        for(int[] i : s.getIntervals()){
            System.out.print(Arrays.toString(i) + ", ");
        }
        System.out.println();
        s.addNum(6);
        for(int[] i : s.getIntervals()){
            System.out.print(Arrays.toString(i) + ", ");
        }
    }
}
