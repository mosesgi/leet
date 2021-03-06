package com.moses.leet.n0300;

import com.moses.leet.pojo.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public class Codec {
        //1,2,#,#,3,4,#,#,5,#,#
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            seriaDfs(root, sb);
            sb.setLength(sb.length()-1);
            return sb.toString();
        }

        void seriaDfs(TreeNode root, StringBuilder sb){
            if(root == null){
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(",");
            seriaDfs(root.left, sb);
            seriaDfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return des(queue);
        }

        private TreeNode des(LinkedList<String> queue) {
            String cur = queue.pollFirst();
            if("#".equals(cur)){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(cur));
            node.left = des(queue);
            node.right = des(queue);
            return node;
        }
    }


    public class Codec1 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            sb.setLength(sb.length()-1);
            return sb.toString();
        }

        void dfs(TreeNode root, StringBuilder sb){
            if(root == null){
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return des(q);
        }

        TreeNode des(Deque<String> q){
            String val = q.pollFirst();
            if("#".equals(val)){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = des(q);
            node.right = des(q);
            return node;
        }
    }






//    public class Codec {
//
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            StringBuilder sb = new StringBuilder("[");
//
//            if(root == null){
//                sb.append("]");
//                return sb.toString();
//            }
//
//            Queue<TreeNode> q = new LinkedList<>();
//            q.offer(root);
//            while(!q.isEmpty()){
//                TreeNode n = q.poll();
//                if(n == null){
//                    sb.append("null,");
//                    continue;
//                }
//                sb.append(n.val).append(",");
//                q.offer(n.left);
//                q.offer(n.right);
//            }
//            sb.setLength(sb.length()-1);
//            sb.append("]");
//            return sb.toString();
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            if(data.length() == 2){
//                return null;
//            }
//            data = data.substring(1, data.length()-1);
//            String[] ns = data.split(",");
//            int i=0;
//            Queue<TreeNode> q = new LinkedList<>();
//            TreeNode root = new TreeNode(Integer.parseInt(ns[i++]));
//            q.offer(root);
//            while(!q.isEmpty()){
//                TreeNode n = q.poll();
//                if(n == null){
//                    continue;
//                }
//                String l = ns[i++];
//                if(!l.equals("null")){
//                    n.left = new TreeNode(Integer.parseInt(l));
//                    q.offer(n.left);
//                }
//                String r = ns[i++];
//                if(!r.equals("null")){
//                    n.right = new TreeNode(Integer.parseInt(r));
//                    q.offer(n.right);
//                }
//            }
//            return root;
//        }
//    }

    public static void main(String[] args) {
        Codec codec = new SerializeAndDeserializeBinaryTree().new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(codec.serialize(root));

//        TreeNode r = codec.deserialize("[1,2,3,null,null,null,5,null,null,null,null]");
        TreeNode r = codec.deserialize("1,2,#,#,3,4,#,#,5,#,#");
        System.out.println(r.val);
    }

}
