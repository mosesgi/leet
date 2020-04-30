package com.moses.leet.n0140;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return sum;
        }
        dfs(root, 0);
        return sum;
    }

    void dfs(TreeNode root, int num){
        num*=10;
        num+=root.val;
        if(root.left == null && root.right == null){
            sum+=num;
            return;
        }
        if(root.left != null){
            dfs(root.left, num);
        }
        if(root.right != null){
            dfs(root.right, num);
        }
    }


    List<Integer> list = new ArrayList<>();
    public int sumNumbersOld(TreeNode root){
        if(root == null){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        int sum = 0;
        for(Integer i : list){
            sum+=i;
        }
        return sum;
    }

    private void traverse(TreeNode node, StringBuilder sb){
        if(node.left == null && node.right == null){
            sb.append(node.val);
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        sb.append(node.val);
        if(node.left != null){
            traverse(node.left, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(node.right != null){
            traverse(node.right, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));

        root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));

        root = new TreeNode(1);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));

    }
}
