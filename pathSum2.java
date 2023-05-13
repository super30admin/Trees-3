// Time Complexity : O(n+L) where n is number of nodes in tree and L is the
//    level of the leaf nodes in worst case
// Space Complexity : O(h+h) for recursion stack and the extra array that we
//    use to store the elements before backtracking
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We keep traversing the tree using DFS till each leaf, all the while storing
 * the sum of all elements found until now. When we reach the leaf node, we
 * check if the sum is equal to our target. If it is, store that in the result
 * array and then backtrack to it's parent so that next path can be compared.
 * This is an optimization of recursion.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    int tSum;
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }
        tSum = targetSum;
        res = new ArrayList<>();
        dfs(root, 0, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path) {
        if(root == null) {
            return;
        }

        sum += root.val; // compute sum till current node in path
        path.add(root.val); // add current node to current path

        if(root.left == null && root.right == null) {
            if(sum == tSum) { // if target sum reached at leaf
                // we need to add a new List here since
                // we're making use of the same single
                // ArrayList reference for all paths
                res.add(new ArrayList<>(path));
            }
        }

        dfs(root.left, sum, path);
        dfs(root.right, sum, path);
        path.remove(path.size()-1); // remove last element to backtrack
    }
}