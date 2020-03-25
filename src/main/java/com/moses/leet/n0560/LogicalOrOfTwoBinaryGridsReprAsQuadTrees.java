package com.moses.leet.n0560;

public class LogicalOrOfTwoBinaryGridsReprAsQuadTrees {
    public Node intersect(Node quadTree1, Node quadTree2) {
        Node root = null;
        if(quadTree1.isLeaf && quadTree2.isLeaf){
            root = new Node(quadTree1.val|quadTree2.val, true, null, null, null, null);
        }else if(quadTree1.isLeaf && !quadTree2.isLeaf){
            if(!quadTree1.val){
                root = quadTree2;
            }else{
                root = quadTree1;
            }
        }else if(!quadTree1.isLeaf && quadTree2.isLeaf){
            if(!quadTree2.val){
                root = quadTree1;
            }else{
                root = quadTree2;
            }
        }else{
            root = new Node(false, false, intersect(quadTree1.topLeft, quadTree2.topLeft),
                    intersect(quadTree1.topRight, quadTree2.topRight),
                    intersect(quadTree1.bottomLeft, quadTree2.bottomLeft),
                    intersect(quadTree1.bottomRight, quadTree2.bottomRight));
            if(root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf){
                boolean val = root.topLeft.val;
                if(root.topRight.val == val && root.bottomLeft.val == val && root.bottomRight.val == val){
                    root = new Node(val, true, null,null,null,null);
                }
            }
        }
        return root;
    }


    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
