package com.moses.leet.utils;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.pojo.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintUtil {
    public static void traverseNodes(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix){
        for(int[] i:matrix){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    public static void printMatrixChar(char[][] matrix){
        for(char[] i:matrix){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    public static <T> void printNestedList(List<List<T>> list) {
        for(List<T> l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();
    }

    public static void printTreeNodes(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            System.out.print(tmp==null?"null,":tmp.val + ",");
            if(tmp == null){
                continue;
            }
            q.add(tmp.left);
            q.add(tmp.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode left1= new TreeNode(1);
        left.left = left1;
        printTreeNodes(root);
    }
}
