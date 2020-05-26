package com.moses.leet.n0340;

import com.moses.leet.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LargestBSTSubtree {
    Map<TreeNode, Integer> sizeMap = new HashMap<>();
    Map<TreeNode, int[]> minMax = new HashMap<>();
    int size = 0;
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return size;
    }

    boolean dfs(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if(left && right){
            if(root.left == null && root.right == null){
                sizeMap.put(root, 1);
                minMax.put(root, new int[]{root.val, root.val});
                if(1 > size){
                    size = 1;
                }
                return true;
            }else if(root.left == null){
                if(root.val < minMax.get(root.right)[0]){
                    sizeMap.put(root, 1+sizeMap.get(root.right));
                    minMax.put(root, new int[]{root.val, minMax.get(root.right)[1]});
                    if(sizeMap.get(root) > size){
                        size = sizeMap.get(root);
                    }
                    return true;
                }
            }else if(root.right == null){
                if(root.val > minMax.get(root.left)[1]){
                    sizeMap.put(root, 1+sizeMap.get(root.left));
                    minMax.put(root, new int[]{minMax.get(root.left)[0], root.val});
                    if(sizeMap.get(root) > size){
                        size = sizeMap.get(root);
                    }
                    return true;
                }
            }else{
                if(root.val > minMax.get(root.left)[1] && root.val < minMax.get(root.right)[0]){
                    sizeMap.put(root, 1+sizeMap.get(root.left) + sizeMap.get(root.right));
                    minMax.put(root, new int[]{minMax.get(root.left)[0], minMax.get(root.right)[1]});
                    if(sizeMap.get(root) > size){
                        size = sizeMap.get(root);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
