package com.moses.leet.n0280;

import com.moses.leet.pojo.TreeNode;

import java.util.List;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 *
 *     Given target value is a floating point.
 *     You may assume k is always valid, that is: k ≤ total nodes.
 *     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: [4,3]
 *
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 *
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        return null;
    }
}


/**

 follow up 要求当树为AVL的时候，在O(max(k, logN))时间完成这道题。
 思路是首先找到和target最接近的节点，然后用双指针依次把剩余的k-1个节点的值加到结果里。
 找里target最近的节点cur就是 270. Closest Binary Search Tree Value 这道题。
 之后以cur为起点，向前向后找第2接近的节点即可。
 AVL里找某个节点的中序遍历下的上一个or下一个节点的平均时间复杂度为O(1)。所以整个时间复杂度是O(logN).
 具体的找法是：

 找当前节点cur在中序遍历下的的上一个节点。
 (1) 若cur有左孩子, 则上一个节点即为cur->left的最右孩子
 (2) 若cur无左孩子, 则看cur是不是其父亲的右孩子，若是则其父亲即为目标节点，否则继续找父亲的父亲，看父亲的父亲的右孩子是否是父亲，若是，则父亲的父亲为目标节点。依次类推，直到没父亲节点了，则说明已经找到了最小的节点。
 找当前节点cur在中序遍历下的下一个节点。
 和1.对称，把1中描述的左孩子都换成右孩子，右孩子换成左孩子即可。

 由于找上一个或下一个节点可能需要当前节点的父节点，所以我们用一个hashmap来记录访问过的节点的父节点是什么，以供查找。

 AC 代码：


class Solution {
    public:
    TreeNode* getSmall(TreeNode *cur, unordered_map<TreeNode*, TreeNode*> &parents){
        if(cur->left){
            TreeNode *pre = cur;
            cur = cur->left;
            parents[cur] = pre;
            pre = cur;
            while(cur->right){
                cur = cur->right;
                parents[cur] = pre;
                pre = cur;
            }
            return cur;
        }
        else{
            if(parents.count(cur) == 0) return NULL;
            TreeNode *p = parents[cur];
            while(p && !(p->right == cur)){
                cur = p;
                p = parents[p];
            }
            if(!p) return NULL;
            else return p;
        }
    }

    TreeNode* getLarge(TreeNode *cur,  unordered_map<TreeNode*, TreeNode*> &parents){
        if(cur->right){
            TreeNode *pre = cur;
            cur = cur->right;
            parents[cur] = pre;
            pre = cur;
            while(cur->left){
                cur = cur->left;
                parents[cur] = pre;
                pre = cur;
            }
            return cur;
        }
        else{
            if(parents.count(cur) == 0) return NULL;
            TreeNode *p = parents[cur];
            while(p && !(p->left == cur)){
                cur = p;
                p = parents[p];
            }
            if(!p) return NULL;
            else return p;
        }
    }

    vector<int> closestKValues(TreeNode* root, double target, int k) {
        if(!root->left && !root->right) return {root->val};
        unordered_map<TreeNode*, TreeNode*> parents;
        auto t = root;
        auto cur = t;
        TreeNode* pre = NULL;
        int Min = abs(root->val - target);
        while(t){
            parents[t] = pre;
            pre = t;
            if(abs(t->val - target) < Min){
                Min = abs(t->val - target);
                cur = t;
            }
            if(target < t->val){
                t = t->left;
            }
            else{
                t = t->right;
            }
        }

        TreeNode *left = getSmall(cur, parents);
        TreeNode *right = getLarge(cur, parents);

        if(left != NULL) right = cur;
        else left = cur;
        vector<int> res;
        while(left && right && k > 0){
            if(abs(left->val - target) < abs(right->val - target)){
                res.push_back(left->val);
                left = getSmall(left, parents);
            }
            else{
                res.push_back(right->val);
                right = getLarge(right, parents);
            }
            k--;
        }
        while(left && k > 0){
            res.push_back(left->val);
            left = getSmall(left, parents);
            k--;
        }
        while(right && k > 0){
            res.push_back(right->val);
            right = getLarge(right, parents);
            k--;
        }
        return res;
    }
};

**/
