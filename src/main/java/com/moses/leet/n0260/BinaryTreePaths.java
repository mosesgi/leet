package com.moses.leet.n0260;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return result;
    }

    public void recursive(TreeNode root, List<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i));
                if(i != list.size()-1){
                    sb.append("->");
                }
            }
            result.add(sb.toString());
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        if(root.left != null){
            recursive(root.left, list);
        }
        if(root.right != null){
            recursive(root.right, list);
        }
        list.remove(list.size()-1);
    }


}
