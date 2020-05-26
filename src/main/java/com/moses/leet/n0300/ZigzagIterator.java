package com.moses.leet.n0300;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {
    Integer next = null;
    LinkedList<Iterator<Integer>> list = new LinkedList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list.add(v1.iterator());
        list.add(v2.iterator());
        while(!list.isEmpty()){
            Iterator<Integer> cur = list.pollFirst();
            if(cur.hasNext()){
                next = cur.next();
                list.addLast(cur);
                break;
            }
        }
    }

    public int next() {
        int tmp = next;
        boolean found = false;
        while(!list.isEmpty()){
            Iterator<Integer> cur = list.pollFirst();
            if(cur.hasNext()){
                next = cur.next();
                list.addLast(cur);
                found = true;
                break;
            }
        }
        if(!found){
            next = null;
        }
        return tmp;
    }

    public boolean hasNext() {
        return next != null;
    }

    public static void main(String[] args) {
        List<Integer> v1, v2;
        v1 = Arrays.asList(1,2);
        v2 = Arrays.asList(3,4,5,6);

        ZigzagIterator iter = new ZigzagIterator(v1, v2);
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
    }
}