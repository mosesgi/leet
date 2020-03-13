package com.moses.leet.n0460;

import com.moses.leet.pojo.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBST {

    // 6,3,1,2,5,4,10,8,7,9,13,11,12,14
    //For BST, no nulls
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node == null){
                    sb.append("#").append(",");
                    continue;
                }else{
                    sb.append(node.val).append(",");
                }
                if(node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
            }
            sb.setLength(sb.length()-1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("#")){
                return null;
            }
            String[] splits = data.split(",");
            Queue<Integer> q = new LinkedList<>();
            for(String s : splits){
                q.offer(Integer.parseInt(s));
            }
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode deserialize(Queue<Integer> q, int small, int big){
            if(q.isEmpty()){
                return null;
            }
            Integer s = q.peek();
            if(s < small || s > big){
                return null;
            }
            q.poll();
            TreeNode node = new TreeNode(s);
            node.left = deserialize(q, small, s);
            node.right = deserialize(q, s, big);
            return node;
        }
    }

    public static void main(String[] args) {
        Codec codec = new SerializeAndDeserializeBST().new Codec();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(13);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(9);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(14);
        root.right.right.left.right = new TreeNode(12);
        String s = codec.serialize(root);
        System.out.println(s);

//        TreeNode des = codec.deserialize(s);
//        System.out.println(des);
    }




    //Standard binary tree.
    // 6,3,1,#,2,#,#,5,4,#,#,#,10,8,7,#,#,9,#,#,13,11,#,12,#,#,14,#,#
    public class CodecBT {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node == null){
                    sb.append("#").append(",");
                    continue;
                }else{
                    sb.append(node.val).append(",");
                }
                stack.push(node.right);
                stack.push(node.left);
            }
            sb.setLength(sb.length()-1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] splits = data.split(",");
            Queue<String> q = new LinkedList<>();
            for(String s : splits){
                q.offer(s);
            }
            return deserialize(q);
        }

        private TreeNode deserialize(Queue<String> q){
            String s = q.poll();
            if("#".equals(s)){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = deserialize(q);
            node.right = deserialize(q);
            return node;
        }
    }



}
