package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), sum, res);
        return res;
    }

    void dfs(TreeNode root, List<Integer> l, int sum, List<List<Integer>> res){
        if(root == null){
            return;
        }else if(root.left == null && root.right == null){
            if(sum == root.val){
                l.add(root.val);
                res.add(new ArrayList<>(l));
                l.remove(l.size() -1);
            }
        }
        l.add(root.val);
        dfs(root.left, l, sum-root.val, res);
        dfs(root.right, l, sum-root.val, res);
        l.remove(l.size()-1);
    }





    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSumOld(TreeNode root, int sum) {
        if(root == null){
            return list;
        }
        List<Integer> row = new ArrayList<>();
        recursive(root, row, 0, sum);

        return list;
    }

    private void recursive(TreeNode root, List<Integer> row, int tmp, int sum) {
        if(root.left == null && root.right == null ){
            if((tmp+root.val) == sum){
                row.add(root.val);
                list.add(new ArrayList<>(row));
                row.remove(row.size() -1);
            }
            return;
        }
        row.add(root.val);
        if(root.left == null && root.right != null){
            recursive(root.right, row, tmp + root.val, sum);
        } else if(root.left != null && root.right == null){
            recursive(root.left, row, tmp+root.val, sum);
        } else {
            recursive(root.left, row, tmp+root.val, sum);
            recursive(root.right, row, tmp+root.val, sum);
        }
        row.remove(row.size()-1);
    }

    public static void main(String[] args) {

    }
}
