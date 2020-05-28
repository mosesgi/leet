package com.moses.leet.n0760;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定员工的 schedule 列表，表示每个员工的工作时间。
 *
 * 每个员工都有一个非重叠的时间段  Intervals 列表，这些时间段已经排好序。
 *
 * 返回表示 所有 员工的 共同，正数长度的空闲时间 的有限时间段的列表，同样需要排好序。
 *
 * 示例 1：
 *
 * 输入：schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * 输出：[[3,4]]
 * 解释：
 * 共有 3 个员工，并且所有共同的
 * 空间时间段是 [-inf, 1], [3, 4], [10, inf]。
 * 我们去除所有包含 inf 的时间段，因为它们不是有限的时间段。
 */
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Element> p = new PriorityQueue<>((o1, o2) -> o1.interval.start - o2.interval.start);
        for(int i=0; i<schedule.size(); i++){
            p.offer(new Element(schedule.get(i).get(0),  i,0));
        }

        int prev = -1;
        while(!p.isEmpty()){
            Element cur = p.poll();
            if(prev == -1){
                prev = cur.interval.end;
            }else{
                if(cur.interval.start > prev){
                    res.add(new Interval(prev, cur.interval.start));
                    prev = cur.interval.end;
                }else{
                    prev = Math.max(prev, cur.interval.end);
                }
            }
            int idx = cur.idx;
            if(idx+1 < schedule.get(cur.row).size()){
                p.offer(new Element(schedule.get(cur.row).get(idx+1), cur.row, idx+1));
            }
        }
        return res;
    }

    class Element{
        Interval interval;
        int row;
        int idx;

        public Element(Interval interval, int row, int idx){
            this.interval = interval;
            this.row = row;
            this.idx = idx;
        }
    }


    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
