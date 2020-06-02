package com.moses.leet.n0960;

import java.util.*;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        //[2,13,3,11,5,17,7]
        //17
        //13, 17  ->  17,13
        //11,17,13 ->  13, 11, 17
        //7, 13,11,17 -> 17,7,13,11
        //5,17,7,13,11 -> 11,5,17,7,13
        //3,11,5,17,7,13 -> 13,3,11,5,17,7
        //2,13,3,11,5,17,7

        Arrays.sort(deck);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : deck){
            list.add(i);
        }

        Deque<Integer> q = new LinkedList<>();
        q.offerLast(list.pollLast());
        if(list.size()> 0) {
            while (list.size() > 1) {
                q.offerFirst(list.pollLast());
                q.offerFirst(q.pollLast());
            }
            q.offerFirst(list.pollLast());
        }
        int[] res = new int[deck.length];
        for(int i=0; i<res.length; i++){
            res[i] = q.pollFirst();
        }
        return res;
    }
}
