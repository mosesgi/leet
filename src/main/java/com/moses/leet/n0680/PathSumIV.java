package com.moses.leet.n0680;

import java.util.Deque;
import java.util.LinkedList;

/**
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
 *
 * For each integer in this list:
 *
 *     The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 *     The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is
 *     the same as that in a full binary tree.
 *     The units digit represents the value V of this node, 0 <= V <= 9.
 *
 * Given a list of ascending three-digits integers representing a binary tree with the depth smaller than 5, you need
 * to return the sum of all paths from the root towards the leaves.
 *
 * It's guaranteed that the given list represents a valid connected binary tree.
 *
 * Example 1:
 *
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation:
 * The tree that the list represents is:
 *     3
 *    / \
 *   5   1
 *
 * The path sum is (3 + 5) + (3 + 1) = 12.
 *
 *
 *
 * Example 2:
 *
 * Input: [113, 221]
 * Output: 4
 * Explanation:
 * The tree that the list represents is:
 *     3
 *      \
 *       1
 *
 * The path sum is (3 + 1) = 4.
 *
 */
public class PathSumIV {
    public int pathSum(int[] nums) {
        Deque<int[]> q = new LinkedList<>();
        int sum = 0;
        for(int i : nums){
            int val = i%10;
            i/=10;
            int pos = i%10;
            i/=10;
            int level = i%10;
            if(q.isEmpty()){
                q.offerLast(new int[]{level, pos, val, 0});
                continue;
            }
            int pPos = pos%2==1?(pos+1)/2:pos/2;
            while(!q.isEmpty() && (q.peekFirst()[0] < level-1 || q.peekFirst()[0] == level-1 && q.peekFirst()[1] < pPos)){
                int[] tmp = q.pollFirst();
                if(tmp[3] == 0){
                    sum += tmp[2];
                }
            }
            int[] parent = q.peekFirst();
            parent[3]++;
            q.offerLast(new int[]{level, pos, val+parent[2], 0});
        }

        while(!q.isEmpty()){
            int[] cur = q.pollFirst();
            if(cur[3] == 0){
                sum+=cur[2];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{113,229,349,470,485};
        System.out.println(new PathSumIV().pathSum(nums));
    }
}
