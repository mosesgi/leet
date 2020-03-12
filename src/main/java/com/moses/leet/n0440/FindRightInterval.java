package com.moses.leet.n0440;

import java.util.*;

public class FindRightInterval {

    //TreeMap
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();        //key: start, value: pos
        for(int i=0; i<intervals.length; i++){
            map.put(intervals[i][0], i);
        }

        int[] rst = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            int[] curr = intervals[i];
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(curr[1]);
            if(entry == null){
                rst[i] = -1;
            }else{
                rst[i] = entry.getValue();
            }
        }
        return rst;
    }


    public int[] findRightIntervalMineSlow(int[][] intervals) {
        List<Element> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            int[] ints = intervals[i];
            list.add(new Element(ints, i));
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            int start = -1;
            Element a = list.get(i);
            for(int j=i+1; j<list.size(); j++){     //can be enhanced by BinarySearch
                Element b = list.get(j);
                if(b.ints[0] >= a.ints[1]){
                    start = b.pos;
                    break;
                }
            }
            a.start = start;
        }

        Collections.sort(list, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2){
                return e1.pos - e2.pos;
            }
        });
        int[] result = new int[intervals.length];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i).start;
        }
        return result;
    }

    class Element implements Comparable<Element>{
        int[] ints;
        int pos;
        int start;

        Element(int[] ints, int pos){
            this.ints = ints;
            this.pos = pos;
        }

        @Override
        public int compareTo(Element e){
            if(ints[0] != e.ints[0]){
                return ints[0] - e.ints[0];
            }
            return ints[1] - e.ints[1];
        }
    }
}
