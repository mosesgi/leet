package com.moses.leet.n0540;

import com.moses.leet.pojo.TreeNode;

public class MinimumAbsoluteDiffInBST {
    int min = Integer.MAX_VALUE;
    //in-order traversal
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root.left != null){
            getMinimumDifference(root.left);
        }

        if(prev != null){
            min = Math.min(root.val - prev, min);
        }
        prev = root.val;

        if(root.right != null){
            getMinimumDifference(root.right);
        }
        return min;
    }

    //左子树的最右节点,右子树的最左结点, 与根结点的差为最小
    public int getMinimumDifferenceMyComplex(TreeNode root) {
        int[] left = new int[]{root.val, root.val};
        int[] right = new int[]{root.val, root.val};
        if(root.left != null){
            left = getValue(root.left, true);
        }
        if(root.right!= null){
            right = getValue(root.right, false);
        }
        if(left[1] != root.val){
            min = Math.min(root.val-left[1], min);
        }
        if(right[0] != root.val){
            min = Math.min(right[0]-root.val, min);
        }
        return min;
    }

    private int[] getValue(TreeNode root, boolean isLeft) {
        int[] left = new int[]{root.val, root.val};
        int[] right = new int[]{root.val, root.val};
        if(root.left != null){
            left = getValue(root.left, true);
        }
        if(root.right!= null){
            right = getValue(root.right, false);
        }
        if(left[1] != root.val){
            min = Math.min(root.val-left[1], min);
        }
        if(right[0] != root.val){
            min = Math.min(right[0]-root.val, min);
        }
        return new int[]{left[0], right[1]};
    }


    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(new MinimumAbsoluteDiffInBST().getMinimumDifference(root));

        root = new TreeNode(0);
        root.right = new TreeNode(2236);
        root.right.left = new TreeNode(1277);
        root.right.right = new TreeNode(2776);
        root.right.left.left = new TreeNode(519);
        System.out.println(new MinimumAbsoluteDiffInBST().getMinimumDifference(root));
    }
}
