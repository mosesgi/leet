package com.moses.leet.n0900;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {
    Map<Integer, List<TreeNode>> mem = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if(N%2==0){
            return new ArrayList<>();
        }
        if(mem.containsKey(N)){
            return mem.get(N);
        }
        List<TreeNode> res = new ArrayList<>();
        if(N==1){
            res.add(new TreeNode(0));
            mem.put(N, res);
            return res;
        }
        for(int left=1; left<N-1; left+=2){
            int right = N-1-left;
            List<TreeNode> lefts = allPossibleFBT(left);
            List<TreeNode> rights = allPossibleFBT(right);
            for(TreeNode l : lefts){
                for(TreeNode r : rights){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        mem.put(N, res);
        return res;
    }
}
