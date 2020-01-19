package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedAryToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        } else if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        return recursive(nums, 0, nums.length-1);
    }

    private TreeNode recursive(int[] nums, int start, int end) {
        if(end < start){
            return null;
        }
        if(end == start){
            return new TreeNode(nums[start]);
        }
        int middle = start + (end-start)/2;
        TreeNode curr = new TreeNode(nums[middle]);
        curr.left = recursive(nums, start, middle-1);
        curr.right = recursive(nums, middle+1, end);
        return curr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = new ConvertSortedAryToBST().sortedArrayToBST(nums);
        PrintUtil.printTreeNodes(root);
    }


}
