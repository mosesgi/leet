package com.moses.leet.n0380;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:

 Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4  5

 Output: [[4,5,3],[2],[1]]


 Explanation:

 1. Removing the leaves [4,5,3] would result in this tree:

    1
  /
 2


 2. Now removing the leaf [2] would result in this tree:

 1


 3. Now removing the leaf [1] would result in the empty tree:

 []
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Map<TreeNode, Integer> cnt = new HashMap<>();
        dfs(root, cnt);
        int max = cnt.get(root);
        List<Integer>[] l = new List[max+1];
        for(TreeNode n : cnt.keySet()){
            int v = cnt.get(n);
            if(l[v] == null){
                l[v] = new ArrayList<>();
            }
            l[v].add(n.val);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> row : l){
            res.add(row);
        }
        return res;
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> cnt) {
        int level;
        if(root.left == null && root.right == null){
            level = 0;
        }else if(root.left != null && root.right == null){
            level = dfs(root.left, cnt) + 1;
        }else if(root.left == null && root.right != null){
            level = dfs(root.right, cnt) + 1;
        }else{
            level = Math.max(dfs(root.left, cnt), dfs(root.right, cnt)) + 1;
        }

        cnt.put(root, level);
        return level;
    }
}
