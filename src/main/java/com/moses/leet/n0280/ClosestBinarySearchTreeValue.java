package com.moses.leet.n0280;

import com.moses.leet.pojo.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 *     Given target value is a floating point.
 *     You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 *
 */
public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        dfs1(root, target, null, null);
        return res;
    }

    void dfs1(TreeNode root, double target, Integer min, Integer max){
        if(min != null){
            if(target -min < diff){
                diff = target - min;
                res = min;
            }
        }
        if(max != null){
            if(max - target < diff){
                diff = max - target;
                res = max;
            }
        }
        if(root == null){
            return;
        }
        if(root.val > target){
            dfs1(root.left, target, min, root.val);
        }else if(root.val < target){
            dfs1(root.right, target, root.val, max);
        }else if(root.val == target){
            res = root.val;
            diff = 0d;
        }
    }

    Integer res =null;
    Double diff = Double.MAX_VALUE;
    public int closestValueOld(TreeNode root, double target) {
        dfs(root, target);
        return res;
    }

    void dfs(TreeNode root, double target){
        if(root == null){
            return;
        }
        dfs(root.left, target);
        dfs(root.right, target);
        double d = Math.abs((double)root.val - target);
        if( d< diff){
            diff = d;
            res = root.val;
        }
    }

}
