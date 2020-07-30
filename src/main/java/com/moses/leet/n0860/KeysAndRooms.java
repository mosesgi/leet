package com.moses.leet.n0860;

import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        List<Integer> newRoom = new ArrayList<>();
        newRoom.add(0);
        int n = rooms.size();
        while(!newRoom.isEmpty()){
            List<Integer> nextRooms = new ArrayList<>();
            for(int i : newRoom){
                for(int j : rooms.get(i)){
                    if(!set.contains(j) && j<n){
                        set.add(j);
                        nextRooms.add(j);
                    }
                }
            }
            newRoom = nextRooms;
        }
        return set.size() == n;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms =new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
    }

}
