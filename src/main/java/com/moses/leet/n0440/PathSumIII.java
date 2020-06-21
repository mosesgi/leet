package com.moses.leet.n0440;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return presum(root, 0, map, sum);
    }

    int presum(TreeNode root, int pValue, Map<Integer, Integer> map, int sum){
        if(root == null){
            return 0;
        }
        int count = 0;
        int cur = root.val + pValue;
        if(map.containsKey(cur-sum)){
            count += map.get(cur-sum);
        }
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        count += presum(root.left, cur, map, sum);
        count += presum(root.right, cur, map, sum);
        map.put(cur, map.get(cur) - 1);
        return count;
    }



    int cnt = 0;
    public int pathSumRec(TreeNode root, int sum) {
        recursive(root, sum);
        return cnt;
    }

    private List<Integer> recursive(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> tmp = new ArrayList<>();
        if(root.left != null) {
            List<Integer> left = recursive(root.left, sum);
            for(int i : left){
                int curr = i+root.val;
                if(curr == sum){
                    cnt++;
                }
                tmp.add(curr);
            }
        }
        if(root.right != null) {
            List<Integer> right = recursive(root.right, sum);
            for (int i : right) {
                int curr = i+root.val;
                if(curr == sum){
                    cnt++;
                }
                tmp.add(curr);
            }
        }
        tmp.add(root.val);
        if(root.val == sum){
            cnt++;
        }
        return tmp;
    }
}
