package com.moses.leet.n0460;

import com.moses.leet.n0300.SerializeAndDeserializeBinaryTree;
import com.moses.leet.pojo.TreeNode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            TreeNode left = root.left;
            if(root.right != null){
                root = root.right;
                TreeNode mostLeft = root;
                while(mostLeft.left != null){
                    mostLeft = mostLeft.left;
                }
                mostLeft.left = left;
                return root;
            } else {
                return left;
            }
        } else if(root.val < key){
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    //recursive
    public TreeNode deleteNode1(TreeNode root, int key){
        if(root == null){
            return root;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        } else if(root.val < key){
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode mostLeft = root.right;
            while(mostLeft.left != null){
                mostLeft = mostLeft.left;
            }
            mostLeft.left = root.left;
            return root.right;
        }
        return root;
    }

    public TreeNode deleteNodeMyIterative(TreeNode root, int key) {
        //Find node and parent node
        if(root == null){
            return null;
        }
        if(root.val == key && root.left == null){
            return root.right;
        }
        TreeNode parent = null;
        TreeNode curr = root;
        boolean isLeft = false;
        while(curr != null && curr.val != key){
            parent = curr;
            if(curr.val < key){
                curr = curr.right;
                isLeft = false;
            }else if(curr.val > key){
                curr = curr.left;
                isLeft = true;
            }
        }
        if(curr == null){
            return root;
        }
        //connect parent to delNode's left (delLeftNode)
        if(curr.left == null){
            if(parent != null) {
                if (isLeft) {
                    parent.left = curr.right;
                } else {
                    parent.right = curr.right;
                }
            }
            return root;
        }

        TreeNode delLeftNode = curr.left;
        if(parent != null) {
            if (isLeft) {
                parent.left = delLeftNode;
            } else {
                parent.right = delLeftNode;
            }
        }else{
            root = delLeftNode;
        }
        //keep reference of delLeftNode's right child (orphanRightNode)
        //connect delLeftNode's right to delNode's right child
        TreeNode orphanRightNode = delLeftNode.right;
        delLeftNode.right = curr.right;

        //Find delNode's right child's most left leaf, connect the leaf's left to orphanRightNode
        if (orphanRightNode != null) {
            TreeNode mostLeft = delLeftNode;
            if(mostLeft.right == null){
                mostLeft.right = orphanRightNode;
                return root;
            }
            mostLeft = mostLeft.right;
            while(mostLeft.left != null){
                mostLeft = mostLeft.left;
            }
            mostLeft.left = orphanRightNode;
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree.Codec c = new SerializeAndDeserializeBinaryTree().new Codec();
        DeleteNodeInBST del = new DeleteNodeInBST();
        TreeNode root = null;
        root = c.deserialize("[2,1,3,null,null,null,null]");
        root = del.deleteNode(root, 2);
        System.out.println(c.serialize(root));

        root = c.deserialize("[3,1,4,null,2,null,null,null,null]");
        root = del.deleteNode(root, 1);
        System.out.println(c.serialize(root));

        root = c.deserialize("[6,3,10,1,5,8,13,null,2,4,null,7,9,11,14,null,null,null,null,null,null,null,null,null,12,null,null,null,null]");
        root = del.deleteNode(root, 13);
        System.out.println(c.serialize(root));
    }
}
