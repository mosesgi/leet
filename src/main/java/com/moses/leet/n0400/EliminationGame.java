package com.moses.leet.n0400;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EliminationGame {
    public int lastRemaining(int n){
//        if(n==1) return 1;
//        if(n==2) return 2;
//        int[] dpA = new int[n+1];
//        int[] dpD = new int[n+1];
//        dpA[1] = 1;
//        dpA[2] = 2;
//        dpD[1] = 1;
//        dpD[2] = 1;
//        for(int i=3; i<=n; i++){
//            dpA[i] = dpD[i/2] * 2;
//            if(i%2==0){
//                dpD[i] = dpA[i/2] * 2 -1;
//            } else {
//                dpD[i] = dpA[i / 2] * 2;
//            }
//        }

        return recursive(n, true);

    }

    private int recursive(int n, boolean leftToRight){
        if(n==1) return 1;
        if(leftToRight){
            return 2* recursive(n/2, !leftToRight);
        }else {
            if(n%2 == 0){
                return 2*recursive(n/2, !leftToRight) -1;
            } else {
                return 2*recursive(n/2, !leftToRight);
            }
        }
    }

    public int lastRemainingNaive(int n){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        while(list.size() != 1){
            int pos = 0;
            Iterator<Integer> it1 = list.iterator();
            while(it1.hasNext()){
                it1.next();
                if(pos%2==0){
                    it1.remove();
                }
                pos++;
            }

            if(list.size()==1){
                break;
            }

            pos = 0;
            Iterator<Integer> it2 = list.descendingIterator();
            while(it2.hasNext()){
                it2.next();
                if(pos%2==0){
                    it2.remove();
                }
                pos++;
            }
        }
        return list.getFirst();
    }


    public static void main(String[] args) {
        System.out.println(new EliminationGame().lastRemaining(9));
        //1,2,3,4,5,6,7,8,9,10
        //2,4,6,8,10
        //4,8
        //8
        System.out.println(new EliminationGame().lastRemaining(10));
        System.out.println(new EliminationGame().lastRemaining(11));

        //2,4,6,8,10,12
        //2,6,10
        //6
        System.out.println(new EliminationGame().lastRemaining(12));


        System.out.println(new EliminationGame().lastRemaining(30));
        System.out.println(new EliminationGame().lastRemaining(31));
        System.out.println(new EliminationGame().lastRemaining(32));
        System.out.println(new EliminationGame().lastRemaining(33));
        System.out.println(new EliminationGame().lastRemaining(1000));
        System.out.println(new EliminationGame().lastRemaining(10000000));
        System.out.println(new EliminationGame().lastRemaining(100000000));
    }
}
