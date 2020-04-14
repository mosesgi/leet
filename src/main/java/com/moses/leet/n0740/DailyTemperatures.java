package com.moses.leet.n0740;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] rst = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<T.length; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int d = stack.pop();
                rst[d] = i - d;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            rst[stack.pop()] = 0;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] T;
        T = new int[]{73, 74, 75, 73, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(T)));
    }
}
