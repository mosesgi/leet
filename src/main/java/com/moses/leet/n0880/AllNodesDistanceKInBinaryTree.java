package com.moses.leet.n0880;

import com.moses.leet.pojo.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        if(root == null || K < 0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        buildTree(root, null, map);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);
                if (K == 0){
                    result.add(node.val);
                    continue;
                }
                for(TreeNode relatedNode : map.getOrDefault(node, new ArrayList<>())) {
                    q.offer(relatedNode);
                }
            }
            K--;
        }
        return result;
    }

    private void buildTree(TreeNode root, TreeNode parent, Map<TreeNode, List<TreeNode>> map) {
        if(root == null){
            return;
        }
        if(parent != null){
            map.computeIfAbsent(root, x -> new ArrayList<>()).add(parent);
            map.computeIfAbsent(parent, x -> new ArrayList<>()).add(root);
        }
        buildTree(root.left, root, map);
        buildTree(root.right, root, map);

    }



    public List<Integer> distanceK_1(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        dfs(root, parentMap);

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> under = new LinkedList<>();
        under.offer(target);
        int steps = 0;
        while(!under.isEmpty()){
            int size = under.size();
            for(int i=0; i<size; i++){
                TreeNode cur = under.poll();
                if(steps == K){
                    res.add(cur.val);
                    continue;
                }
                if(cur.left != null){
                    under.offer(cur.left);
                }
                if(cur.right != null){
                    under.offer(cur.right);
                }
            }
            steps++;
        }

        if(target == root){
            return res;
        }
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> upper = new LinkedList<>();
        upper.offer(parentMap.get(target));
        visited.add(target);
        steps = 1;
        while(!upper.isEmpty()){
            int size = upper.size();
            for(int i=0; i<size; i++){
                TreeNode cur = upper.poll();
                visited.add(cur);
                if(steps == K){
                    res.add(cur.val);
                    continue;
                }
                if(parentMap.containsKey(cur) && !visited.contains(parentMap.get(cur))){
                    upper.offer(parentMap.get(cur));
                }
                if(cur.left != null && !visited.contains(cur.left)){
                    upper.offer(cur.left);
                }
                if(cur.right != null && !visited.contains(cur.right)){
                    upper.offer(cur.right);
                }
            }
            steps++;
        }
        return res;
    }

    void dfs(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        if(root == null){
            return;
        }
        if(root.left != null){
            parentMap.put(root.left, root);
        }
        if(root.right != null){
            parentMap.put(root.right, root);
        }
        dfs(root.left, parentMap);
        dfs(root.right, parentMap);
    }
}
