package com.moses.leet.n0440;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    int cnt = 0;
    public int pathSum(TreeNode root, int sum) {
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
