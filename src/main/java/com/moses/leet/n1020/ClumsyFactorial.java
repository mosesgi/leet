package com.moses.leet.n1020;

import java.util.Deque;
import java.util.LinkedList;

public class ClumsyFactorial {
    Character op = null;
    public int clumsy(int N) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        int prev = N;
        while(N-1>0){
            char o = getNext();
            int next = N-1;
            if(o == '*'){
                prev *= next;
            }else if(o=='/'){
                prev /= next;
            }else if(o=='+'){
                nums.addLast(prev);
                ops.addLast(o);
                prev = next;
            }else if(o=='-'){
                nums.addLast(prev);
                ops.addLast(o);
                prev = next;
            }
            op = o;
            N--;
        }
        nums.addLast(prev);

        int res = nums.pollFirst();
        while(!ops.isEmpty()){
            if(ops.pollFirst() == '+'){
                res+=nums.pollFirst();
            }else{
                res-= nums.pollFirst();
            }
        }
        return res;
    }

    char getNext(){
        if(op == null){
            return '*';
        }
        if(op == '*'){
            return '/';
        }else if(op == '/'){
            return '+';
        }else if(op == '+'){
            return '-';
        }else{
            return '*';
        }
    }
}
