package com.moses.leet.n0660;

import com.moses.leet.pojo.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    private TreeNode construct(int[] nums, int l, int r) {
        if(r<0 || l >=nums.length || l>r){
            return null;
        }
        if(l==r){
            return new TreeNode(nums[l]);
        }
        int max = nums[l];
        int pos = l;
        for(int i=l; i<=r; i++){
            if(nums[i] > max){
                max = nums[i];
                pos = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = construct(nums, l, pos-1);
        root.right = construct(nums, pos+1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{3,2,1,6,0,5};
        System.out.println(new MaximumBinaryTree().constructMaximumBinaryTree(nums));
    }
}
