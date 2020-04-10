package com.moses.leet.n0740;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarTwo {

    List<Interval> one;
    List<Interval> two;
    public MyCalendarTwo() {
        one = new ArrayList<>();
        two = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(Interval t : two){
            if(start < t.end && end > t.begin){
                return false;
            }
        }

        for(Interval t : one){
            if(start < t.end && end > t.begin){
                two.add(new Interval(Math.max(start, t.begin), Math.min(end, t.end)));
            }
        }
        one.add(new Interval(start, end));
        return true;
    }

    class Interval{
        int begin;
        int end;

        public Interval(int begin, int end){
            this.begin = begin;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo t = new MyCalendarTwo();
        System.out.println(t.book(10, 20));
        System.out.println(t.book(50, 60));
        System.out.println(t.book(10, 40));
        System.out.println(t.book(5, 15));
        System.out.println(t.book(5, 10));
        System.out.println(t.book(25,55));
    }
}
