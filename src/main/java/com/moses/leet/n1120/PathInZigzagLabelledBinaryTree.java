package com.moses.leet.n1120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        if(label == 1){
            return Arrays.asList(1);
        }
        //[1,3,7,15,...]
        List<Integer> levelNums = new ArrayList<>();
        int bPos=1;
        int sum = 1;
        while(sum < label){
            levelNums.add(sum);
            sum += (1 << bPos++);
        }
        levelNums.add(sum);

        int levels = levelNums.size();
        boolean leftToRight = levels %2 == 1;
        int pos;        //from 0
        if(leftToRight){
            pos = label - levelNums.get(levels-2) -1;
        }else{
            pos = levelNums.get(levels-1) - label;
        }
        List<Integer> res = new ArrayList<>();
        res.add(label);

        leftToRight = !leftToRight;
        for(int i=levels-2; i>0; i--){
            pos /= 2;
            if(leftToRight){
                label = levelNums.get(i-1) + 1 + pos;
            }else{
                label = levelNums.get(i) - pos;
            }
            res.add(label);
            leftToRight = !leftToRight;
        }
        res.add(1);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PathInZigzagLabelledBinaryTree().pathInZigZagTree(14).toArray()));
        System.out.println(Arrays.toString(new PathInZigzagLabelledBinaryTree().pathInZigZagTree(26).toArray()));
    }
}
