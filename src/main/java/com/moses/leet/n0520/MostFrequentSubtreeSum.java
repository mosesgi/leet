package com.moses.leet.n0520;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        recursive(root, map);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                list.clear();
                list.add(key);
            }else if(map.get(key) == max){
                list.add(key);
            }
        }
        int[] rst = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            rst[i] = list.get(i);
        }
        return rst;
    }

    private int recursive(TreeNode root, Map<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        int leftSum = recursive(root.left, map);
        int rightSum = recursive(root.right, map);
        int currSum = leftSum + rightSum + root.val;
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        return currSum;
    }


}
