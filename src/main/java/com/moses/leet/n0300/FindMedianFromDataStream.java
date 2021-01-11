package com.moses.leet.n0300;

import java.util.*;

public class FindMedianFromDataStream {

    class MedianFinder {
        int count = 0;
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        /** initialize your data structure here. */
        public MedianFinder() {
            left = new PriorityQueue<>((o1, o2) -> o2-o1);
            right = new PriorityQueue<>();
        }

        //2,3; 8,9;  10
        //-1, -2, -3, -4, -5 ;  -3, -2; -1
        public void addNum(int num) {
            count++;
            if(left.isEmpty()){
                left.offer(num);
                return;
            }
            if(right.isEmpty()){
                left.offer(num);
                right.offer(left.poll());
                return;
            }

            if(num > right.peek()){
                right.offer(num);
                if(count%2==1){
                    left.offer(right.poll());
                }
            } else {
                left.offer(num);
                if(count%2 == 0){
                    right.offer(left.poll());
                }
            }
        }

        public double findMedian() {
            if(count==0){
                return 0d;
            }else if(count==1){
                return left.peek();
            }else if(count%2==0){
                return (left.peek() + right.peek())/2d;
            }else{
                return left.peek();
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
