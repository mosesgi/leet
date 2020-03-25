package com.moses.leet.n0560;

import java.util.List;

public class MaximumDepthOfN_aryTree {
    int depth = 0;
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        dfs(root, 1);
        return depth;
    }

    private void dfs(Node root, int level) {
        if(level > depth){
            depth = level;
        }
        for(Node n : root.children){
            dfs(n, level + 1);
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
