package com.moses.leet.n0560;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        Map<String, Integer> map = new HashMap<>();
        boolean[] used = new boolean[boxes.length];
        return dfs(boxes, used, map);
    }

    private int dfs(int[] boxes, boolean[] used, Map<String, Integer> map) {
        int max = 0;
        String key = serialize(used);
        if(map.containsKey(key)){
            return map.get(key);
        }
        for(int i=0; i<boxes.length; i++){
            if(used[i]){
                continue;
            }
            int cur = boxes[i];
            int size = 1;
            Set<Integer> set = new HashSet<>();
            set.add(i);
            while(i+1 < boxes.length && (used[i+1] || boxes[i+1] == cur)){
                if(!used[i+1]){
                    size++;
                    set.add(i+1);
                }
                i++;
            }
            for(int j : set){
                used[j] = true;
            }
            int ps = dfs(boxes, used, map) + size*size;
            max = Math.max(ps, max);
            for(int j : set){
                used[j] = false;
            }
        }
        map.put(key, max);
        return max;
    }

    String serialize(boolean[] used){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<used.length; i++){
            sb.append(used[i]?'1':'0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] boxes;
        boxes = new int[]{3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7};
        System.out.println(new RemoveBoxes().removeBoxes(boxes));

        boxes = new int[]{5, 8, 3, 8, 4, 8, 5, 7, 4, 2};
        System.out.println(new RemoveBoxes().removeBoxes(boxes));

        boxes = new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(new RemoveBoxes().removeBoxes(boxes));
    }
}
