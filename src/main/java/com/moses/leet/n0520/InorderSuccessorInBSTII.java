package com.moses.leet.n0520;

public class InorderSuccessorInBSTII {

    public Node inorderSuccessor(Node node) {
        if(node.right != null){
            return firstLeft(node.right);
        }
        if(node.parent != null){
            if(node.parent.left == node){
                return node.parent;
            }else if(node.parent.right == node){
                return findParent(node);
            }
        }
        return null;
    }

    Node firstLeft(Node n ){
        while(n.left != null){
            n = n.left;
        }
        return n;
    }

    Node findParent(Node p){
        while(p.parent != null){
            if(p.parent.right == p){
                p = p.parent;
            }else{
                return p.parent;
            }
        }
        return null;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
