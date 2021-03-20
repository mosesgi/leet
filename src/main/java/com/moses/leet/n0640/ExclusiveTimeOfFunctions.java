package com.moses.leet.n0640;

import java.util.*;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result =new int[n];
        Stack<Integer> stack = new Stack<>();   //store thread number
        int prev = 0;

        for(String s : logs) {
            String[] strs = s.split(":");
            int thread = Integer.parseInt(strs[0]);
            int time = Integer.parseInt(strs[2]);
            if("start".equals(strs[1])) {
                if(!stack.isEmpty()){
                    result[stack.peek()] += time - prev;
                }
                prev = time;
                stack.push(thread);
            } else {
                result[stack.pop()] += time - prev + 1;
                prev = time + 1;
            }
        }
        return result;
    }


    public int[] exclusiveTime1(int n, List<String> logs) {
        int[] dur = new int[n];
        Stack<Process> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(String s : logs){
            String[] strs = s.split(":");
            int id = Integer.parseInt(strs[0]);
            int time = Integer.parseInt(strs[2]);
            if("start".equals(strs[1])) {
                set.add(id);
                stack.push(new Process(id, time));
            }else{
                Process p = stack.pop();
                p.end = time;
                int tmp = p.end - p.start+1 ;
                p.duration = tmp - p.deduction;
                if(!stack.isEmpty()){
                    stack.peek().deduction+=tmp;
                }
                dur[p.id] += p.duration;
            }
        }
        return dur;
    }

    class Process implements Comparable<Process>{
        int id;
        int start;
        int end;
        int duration;
        int deduction;

        public Process(int id, int start){
            this.id = id;
            this.start = start;
        }

        public Process(int id, int start, boolean ignore){
            this.id = id;
            this.start = start;
        }

        public int compareTo(Process p){
            return (int)(this.start - p.start);
        }
    }

    public static void main(String[] args) {
        List<String> logs;
        logs = Arrays.asList("0:start:0","1:start:5","2:start:6","3:start:9","4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96","2:end:100","1:end:102","2:start:105","2:end:109","0:end:114");
        int n;
        n = 8;
        System.out.println(Arrays.toString(new ExclusiveTimeOfFunctions().exclusiveTime(n, logs)));
    }

//    public int[] exclusiveTimeWrong(int n, List<String> logs) {
//        Map<Integer, List<Process>> map = new HashMap<>();
//        for(String s : logs){
//            String[] strs = s.split(":");
//            int id = Integer.parseInt(strs[0]);
//            long time = Long.parseLong(strs[2]);
//            if("start".equals(strs[1])){
//                map.put(id, new Process(id, time));
//            }else{
//                List<Process> list = map.g
//                map.get(id).end = time;
//                map.get(id).duration = (int)(time - map.get(id).start + 1);
//            }
//        }
//        List<Process> list = new ArrayList<>(map.values());
//        Stack<Process> stack = new Stack<>();
//        for(int i=0; i<list.size(); i++){
//            Process p = list.get(i);
//            while(!stack.isEmpty() && stack.peek().end < p.start){
//                stack.pop();
//            }
//            if(!stack.isEmpty()) {
//                Process prev = stack.peek();
//                if (p.start > prev.start && p.end < prev.end) {
//                    prev.duration = prev.duration - (int)(p.end - p.start + 1);
//                    stack.push(p);
//                }
//            }else{
//                stack.push(p);
//            }
//        }
//        Collections.sort(list, new Comparator<Process>() {
//            @Override
//            public int compare(Process o1, Process o2) {
//                return (int) (o1.id-o2.id);
//            }
//        });
//        int[] rst = new int[list.size()];
//        int idx = 0;
//        for(Process p : list){
//            rst[idx++] = p.duration;
//        }
//        return rst;
//    }


}
