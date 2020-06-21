package com.moses.leet.n0640;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n){
        int[] cnt = new int[26];
        for(char c : tasks){
            cnt[c-'A']++;
        }

        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i : cnt){
            if(i > 0){
                p.offer(i);
            }
        }
        int total = 0;
        while(!p.isEmpty()){
            int tmp = 0;
            List<Integer> list = new ArrayList<>();
            while(tmp <= n && !p.isEmpty()){
                int cur = p.poll();
                if(cur > 1){
                    list.add(cur-1);
                }
                tmp++;
            }
            if(list.isEmpty()){
                total += tmp;
            }else{
                total += n+1;
            }
            p.addAll(list);
        }
        return total;
    }
    //aaaabc 4
    //abc_a___a___a
    //a,a,b,c,d,e,f,g  5
    //a,a,a,b,b,b,b,c,d,e,f,g  3
    //a,a,a,b,b,b,c,c,c  3
    //abicabicabic
    //aaaabbbbcccc  4
    //cabiicabiicabiicab
    public int leastIntervalMine(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(char c : tasks){
            cnt[c-'A']++;
        }

        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i : cnt){
            if(i > 0){
                p.offer(i);
            }
        }
        int total = 0;
        while(!p.isEmpty()){
            int tmp = 0;
            List<Integer> list = new ArrayList<>();
            while(tmp <= n && !p.isEmpty()){
                int cur = p.poll();
                if(cur > 1){
                    list.add(cur-1);
                }
                tmp++;
            }
            if(list.isEmpty()){
                total += tmp;
            }else{
                total += n+1;
            }
            p.addAll(list);
        }
        return total;
    }


    public int leastIntervalFirst(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(char c : tasks){
            cnt[c-'A']++;
        }

        int max = 0;
        int sameMaxCnt = 0;
        int total = 0;
        for(int i=0; i<cnt.length; i++){
            total+= cnt[i];
            if(cnt[i] > max){
                sameMaxCnt = 1;
                max = cnt[i];
            }else if(cnt[i] == max){
                sameMaxCnt++;
            }
        }

        int rest = total-max;
        int spaces = n * (max-1);
        if(sameMaxCnt == 1){
            return rest>spaces?total:spaces+max;
        }else {
            int filled = (sameMaxCnt-1) * (max-1);
            int restSpaces = spaces - filled;
            int left = total - max * sameMaxCnt;
            if(left < restSpaces){
                return spaces + max + sameMaxCnt - 1;
            }else{
                return total;
            }
        }
    }

    public static void main(String[] args) {
        char[] tasks;
        int n;
        tasks = new char[]{'A','A','A','A','B','B','B','B','C','C','C','C','D','D','D','D','E','F'};
        //abcdeabcdfabcdiabcd
        n=4;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));

        tasks = new char[]{'A','A','A','B','B','B'};
        n = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));

        tasks = new char[]{'A','A','A','B','B','B'};
        n = 10;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));
    }
}
