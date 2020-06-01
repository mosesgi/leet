package com.moses.leet.n0260;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 * You may assume each number in the sequence is unique.
 *
 * Consider the following binary search tree:
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * Example 1:
 *
 * Input: [5,2,6,1,3]
 * Output: false
 *
 * Example 2:
 *
 * Input: [5,2,1,3,6]
 * Output: true
 *
 * Follow up:
 * Could you do it using only constant space complexity?
 *
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;
        for(int i=0; i<len; i++){
            boolean biggerFound = false;
            for(int j=i+1; j<len; j++){
                if(biggerFound && preorder[j] < preorder[i]){
                    return false;
                }
                if(preorder[j] > preorder[i]){
                    biggerFound = true;
                }
            }
        }
        return true;
    }



    public boolean verifyPreorderMySlow(int[] preorder) {
        return check(preorder, 0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean check(int[] preorder, int l, int r, int min, int max){
        if(l > r){
            return true;
        }
        int right = r+1;
        for(int i=l; i<=r; i++){
            if(preorder[i] > preorder[l] && right == r+1){
                right = i;
            }
            if(preorder[i] < min || preorder[i] > max){
                return false;
            }
        }
        boolean rSub = check(preorder, right, r, preorder[l], max);
        boolean lSub = check(preorder, l+1, right-1, min, preorder[l]);
        return lSub && rSub;
    }

    public static void main(String[] args) {
        int[] p;
        p = new int[]{4,2,3,1};
        System.out.println(new VerifyPreorderSequenceInBinarySearchTree().verifyPreorder(p));
    }
}
