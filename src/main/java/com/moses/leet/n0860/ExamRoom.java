package com.moses.leet.n0860;

import java.util.Iterator;
import java.util.TreeSet;

public class ExamRoom {
    //0,1,2,3,4,5,6,7,8,9
    //[0,9]; [0,4],[4,9];  [0,2],[2,4],[4,9];   [0,2],[2,9];  5
    private int n;
    TreeSet<Integer> set = new TreeSet<>();
    public ExamRoom(int N) {
        this.n = N;
    }

    public int seat() {
        if(set.size()==0){
            set.add(0);
            return 0;
        }
        int left = -1, right = -1;
        int len = 0;
        int pos = 0;
        Iterator<Integer> iter = set.iterator();
        int prev = 0;
        boolean zeroExist = set.contains(0);
        while(iter.hasNext()){
            int cur = iter.next();
            if(pos == 0 && !zeroExist){
                left = 0;
                right = cur;
                len = cur;
            }else {
                if ((cur - prev) / 2 > len) {
                    left = prev;
                    right = cur;
                    len = (cur - prev)/2;
                }
            }
            prev = cur;
            pos++;
        }
        if(prev != n-1){
            if(n-1 - prev > len){
                set.add(n-1);
                return n-1;
            }
        }
        if(left == 0 && !zeroExist){
            set.add(0);
            return 0;
        }
        int p = left+len;
        set.add(p);
        return p;
    }

    public void leave(int p) {
        set.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom er = new ExamRoom(10);
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        er.leave(4);
        System.out.println(er.seat());
    }
}
