package com.moses.leet.n0100;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    List<TreeNode> generate(int l, int r){
        List<TreeNode> list = new ArrayList<>();
        if(r<l){
            return list;
        }else if(l==r){
            TreeNode node = new TreeNode(l);
            list.add(node);
            return list;
        }
        for(int i=l; i<=r; i++){
            List<TreeNode> left = generate(l, i-1);
            List<TreeNode> right = generate(i+1, r);
            if(left.isEmpty()){
                for (TreeNode rn : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.right = rn;
                    list.add(cur);
                }
            }else if(right.isEmpty()){
                for (TreeNode ln : left) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = ln;
                    list.add(cur);
                }
            }else {
                for (TreeNode ln : left) {
                    for (TreeNode rn : right) {
                        TreeNode cur = new TreeNode(i);
                        cur.left = ln;
                        cur.right = rn;
                        list.add(cur);
                    }
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        List<TreeNode> list = new UniqueBinarySearchTreesII().generateTrees(3);
        for(TreeNode root: list){
            PrintUtil.printTreeNodes(root);
        }

        list = new UniqueBinarySearchTreesII().generateTrees(4);
        for(TreeNode root: list){
            PrintUtil.printTreeNodes(root);
        }
    }


    public List<TreeNode> generateTreesOld(int n) {
        int[] nums = new int[n];
        for(int i=1; i<=n; i++){
            nums[i-1] = i;
        }

        List<TreeNode> lists = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            lists.addAll(recursive(nums, i, 0, n));
        }
        return lists;
    }

    //每个节点（此节点）如果还有子节点，那么都有(左X右)种组合可能。需要把每种可能性实例成一个新的（此节点），加入到List中，供上一级进一步组合
    private List<TreeNode> recursive(int[] nums, int rootPos, int beginPos, int endPos) {

        List<TreeNode> lists = new ArrayList<>();

        List<TreeNode> leftList = new ArrayList<>();
        List<TreeNode> rightList = new ArrayList<>();
        for(int i=beginPos; i<rootPos; i++){
            leftList.addAll(recursive(nums, i, beginPos, rootPos));
        }
        for(int i=rootPos+1; i<endPos; i++){
            rightList.addAll(recursive(nums, i, rootPos+1, endPos));
        }

        if(leftList.isEmpty() && rightList.isEmpty()){
            TreeNode node = new TreeNode(nums[rootPos]);
            lists.add(node);
            return lists;
        } else if(leftList.isEmpty()){
            for(TreeNode right: rightList){
                TreeNode node = new TreeNode(nums[rootPos]);
                node.right = right;
                lists.add(node);
            }
        } else if(rightList.isEmpty()){
            for(TreeNode left: leftList){
                TreeNode node = new TreeNode(nums[rootPos]);
                node.left = left;
                lists.add(node);
            }
        } else {
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(nums[rootPos]);
                    node.left = left;
                    node.right = right;
                    lists.add(node);
                }
            }
        }
        return lists;

    }


}
