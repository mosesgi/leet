package com.moses.leet.n0740;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i : asteroids){
            if(stack.isEmpty() || i>0 || stack.peek()<0){
                stack.push(i);
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == -i){
                stack.pop();
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>0 && stack.peek() < -i){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() == -i){
                stack.pop();
                continue;
            }
            if(stack.isEmpty() || stack.peek()<0){
                stack.push(i);
            }
        }
        int[] rst = new int[stack.size()];
        for(int i=rst.length-1; i>=0; i--){
            rst[i] = stack.pop();
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] as;

        as = new int[]{-2,2,1,-2};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(as)));

        as = new int[]{8,-8};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(as)));

        as = new int[]{10,2,-5};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(as)));

        as = new int[]{-2, -1, 1, 2};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(as)));

        as = new int[]{-1, 1,2,-3};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(as)));

    }
}
