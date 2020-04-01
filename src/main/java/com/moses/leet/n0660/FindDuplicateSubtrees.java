package com.moses.leet.n0660;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {

    List<TreeNode> list = new ArrayList<>();
    Set<String> added = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> map = new HashMap<>();
        serialize(root, map);
        return list;
    }

    private String serialize(TreeNode root, Map<String, TreeNode> map) {
        if(root == null){
            return "#";
        }
        String left = serialize(root.left, map);
        String right = serialize(root.right, map);
        String tmp = root.val + left + right;
        if(map.containsKey(tmp) && !added.contains(tmp)){
            list.add(map.get(tmp));
            added.add(tmp);
        }else {
            map.put(tmp, root);
        }
        return tmp;
    }


    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode((2));
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new FindDuplicateSubtrees().findDuplicateSubtrees(root).toArray()));


        root = new TreeNode((1));
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        System.out.println(Arrays.toString(new FindDuplicateSubtrees().findDuplicateSubtrees(root).toArray()));
    }



}
