package com.moses.leet.n0100;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class UniqueBinarySearchTreesII {

    int leftNums = -1;
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {

        int[] nums = new int[n];
        for(int i=1; i<=n; i++){
            nums[i-1] = i;
        }

        for(int i=0; i<nums.length; i++){
            leftNums = nums.length;
            recursive(nums, i, null, null,0, n);
        }

        return list;
    }

    private void recursive(int[] nums, int rootPos, TreeNode root, TreeNode currNode, int beginPos, int endPos) {
        if(leftNums == nums.length){
            root = new TreeNode(nums[rootPos]);
            leftNums--;
            currNode = root;
        }
        if(leftNums == 0){
            list.add(root);
            root = new TreeNode(nums[rootPos]);
            currNode = root;
            leftNums = nums.length-1;
        }
        for(int i=beginPos; i<rootPos; i++){
            currNode.left = new TreeNode(nums[i]);
            leftNums--;
            recursive(nums, i, root, currNode.left, beginPos, rootPos);
        }
        for(int i=rootPos+1; i<endPos; i++){
            currNode.right = new TreeNode(nums[i]);
            leftNums--;
            recursive(nums, i, root, currNode.right, rootPos+1, endPos);
        }
    }

    public static void main(String[] args) {
        List<TreeNode> list = new UniqueBinarySearchTreesII().generateTrees(3);
        for(TreeNode root: list){
            PrintUtil.printTreeNodes(root);
        }
    }
}
