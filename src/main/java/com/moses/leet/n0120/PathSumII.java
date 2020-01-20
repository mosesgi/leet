package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
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
