package com.moses.leet.n0980;

import java.util.Stack;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> decStack = new Stack<>();
        decStack.push(0);
        for(int i=1; i<A.length; i++){
            if(A[i] < A[decStack.peek()]){
                decStack.push(i);       //单调递减栈
            }
        }

        int max = 0;
        for(int i=A.length-1; i>=0; i--){
            while(!decStack.isEmpty() && A[i] >= A[decStack.peek()]){       // >=则弹出
                max = Math.max(max, i-decStack.pop());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A;
        A = new int[]{9,8,1,0,1,9,4,0,4,1};
        System.out.println(new MaximumWidthRamp().maxWidthRamp(A));
    }
}
