package com.moses.leet.n0300;

import java.util.*;

public class FindMedianFromDataStream {

    class MedianFinder {
        int count = 0;
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        /** initialize your data structure here. */
        public MedianFinder() {
            left = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count++;
            if(left.isEmpty() && right.isEmpty()){
                right.add(num);
            } else if(left.isEmpty() && !right.isEmpty()){
                right.add(num);
                left.offer(right.poll());
            } else if(num<=left.peek()){
                left.add(num);
            } else {
                right.add(num);
            }
            if(count%2==0){
                if(left.size() > right.size()){
                    right.add(left.poll());
                }else if(left.size() < right.size()){
                    left.add(right.poll());
                }
            } else {
                if(left.size() < right.size()-1){
                    left.add(right.poll());
                } else if(left.size() > right.size()-1){
                    right.add(left.poll());
                }
            }
        }

        public double findMedian() {
            if(count%2==0){
                return (left.peek()+right.peek()) * 0.5d;
            } else {
                return right.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder f = new FindMedianFromDataStream().new MedianFinder();
        f.addNum(6);
        System.out.println(f.findMedian());
        f.addNum(10);
        System.out.println(f.findMedian());
        f.addNum(2);
        System.out.println(f.findMedian());
        f.addNum(6);
        System.out.println(f.findMedian());
        f.addNum(5);
        System.out.println(f.findMedian());
        f.addNum(0);
        System.out.println(f.findMedian());
        f.addNum(6);
        System.out.println(f.findMedian());
    }


}
