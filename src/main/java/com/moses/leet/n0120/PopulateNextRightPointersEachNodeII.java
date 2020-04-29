package com.moses.leet.n0120;

public class PopulateNextRightPointersEachNodeII {
    public Node connect(Node root) {
        Node cur = root;
        while(cur != null ){
            Node prev = null;
            Node nextFirst = null;
            Node tmp = cur;
            while(tmp != null){
                if(prev == null){
                    if(tmp.left != null){
                        prev = tmp.left;
                        nextFirst = prev;
                    }
                    if(tmp.right != null){
                        if(prev == null){
                            prev = tmp.right;
                            nextFirst = prev;
                        }else{
                            prev.next = tmp.right;
                            prev = prev.next;
                        }
                    }
                }else{
                    if(tmp.left != null){
                        prev.next = tmp.left;
                        prev = prev.next;
                    }
                    if(tmp.right != null){
                        prev.next = tmp.right;
                        prev = prev.next;
                    }
                }
                tmp = tmp.next;
            }
            cur = nextFirst;
        }

        return root;
    }


    public Node connectOld(Node root) {
        if(root == null){
            return root;
        }
        Node curr = root;
        Node mostLeft = root;
        Node nextLevelPrev = null;
        Node nextLevelCurr = null;

        for(;;){
            if(curr == null){
                if(nextLevelPrev != null){
                    nextLevelPrev.next = null;
                    nextLevelPrev = null;
                } else {
                    break;
                }
                curr = mostLeft;
            }
            if(curr.left == null && curr.right == null){
                curr = curr.next;
                continue;
            } else if(curr.left != null && curr.right == null){
                if(nextLevelPrev == curr.left){
                    curr = curr.next;
                    continue;
                }
                nextLevelCurr = curr.left;
            } else if(curr.left == null && curr.right != null){
                if(nextLevelPrev == curr.right){
                    curr = curr.next;
                    continue;
                }
                nextLevelCurr = curr.right;
            } else {
                if(nextLevelPrev == curr.left){
                    nextLevelCurr = curr.right;
                } else if(nextLevelPrev == curr.right){
                    curr = curr.next;
                    continue;
                } else {
                    nextLevelCurr = curr.left;
                }
            }

            if(nextLevelPrev == null){
                nextLevelPrev = nextLevelCurr;
                mostLeft = nextLevelCurr;
            } else {
                nextLevelPrev.next = nextLevelCurr;
                nextLevelPrev = nextLevelCurr;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        PopulateNextRightPointersEachNodeII outer = new PopulateNextRightPointersEachNodeII();
        Node root = outer.new Node(1);
        root.left = outer.new Node(2);
        root.left.left = outer.new Node(4);
        root.left.right = outer.new Node(5);
        root.right = outer.new Node(3);
        root.right.left = outer.new Node(6);
        root.right.right = outer.new Node(7);
        outer.connect(root);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
