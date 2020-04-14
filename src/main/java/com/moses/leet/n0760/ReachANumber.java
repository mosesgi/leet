package com.moses.leet.n0760;

import java.util.LinkedList;
import java.util.Queue;

public class ReachANumber {

    //pos/neg are same, use positive case only
    //find sum which is bigger than target and difference is even number. (because flip one number will cause even diff)
    //in between just flip number(s) which is(are) same with difference. it's always there.
    public int reachNumber(int target) {
        int sum = 0;
        int steps = 0;
        target = Math.abs(target);
        while(sum < target || (sum-target)%2!=0){
            steps++;
            sum += steps;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new ReachANumber().reachNumber(20));
        System.out.println(new ReachANumber().reachNumber(-1000000000));
    }
}
