package com.moses.leet.n0540;

import com.moses.leet.pojo.TreeNode;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 * Example:
 *
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 *
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * Note:
 *
 *     There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 *     An empty tree is represented by "" instead of "()".
 *
 */
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        return con(s, 0, s.length()-1);
    }

    TreeNode con(String s, int l, int r){
        if(l>r){
            return null;
        }

        int num = 0;
        int sum = 0;
        int mid = l;
        int firstParentheses = l;
        boolean isNeg = false;

        boolean pareFound = false;
        for(int i=l; i<=r; i++){
            if(s.charAt(i) == '('){
                sum++;
                if(!pareFound){
                    firstParentheses = i;
                    pareFound = true;
                }
            }else if(s.charAt(i) == ')'){
                sum--;
            }else if(s.charAt(i) == '-'){
                if(!pareFound) {
                    isNeg = true;
                }
            }else{
                if(!pareFound){
                    num = num*10 + (s.charAt(i) - '0');
                }
            }
            if(pareFound && sum == 0){
                mid = i;
                break;
            }
        }

        if(isNeg){
            num = -num;
        }
        if(!pareFound){
            return new TreeNode(num);
        }
        TreeNode root = new TreeNode(num);
        root.left = con(s, firstParentheses+1, mid-1);
        root.right = con(s, mid+2, r-1);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructBinaryTreeFromString().str2tree("4(2(3)(1))(6(5))"));
    }
}
