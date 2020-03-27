package com.moses.leet.n0640;

import java.util.*;

public class TaskScheduler {

    //a,a,b,c,d,e,f,g  5
    //a,a,a,b,b,b,b,c,d,e,f,g  3
    //a,a,a,b,b,b,c,c,c  3
    //abicabicabic
    //aaaabbbbcccc  4
    //cabiicabiicabiicab
    public int leastInterval(char[] tasks, int n) {
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
