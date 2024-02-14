// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(h) h = height of tree (only recursive stack is using space or the current path array)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Maintaining a single array to keep track while DFS; add to array when you start processing a node
// and delete from it when you have processed it (it's no longer part of the path). At leaf nodes,
// check if sum = targetSum and if yes, append it to the result.

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<List<Integer>> res;
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res = new ArrayList<>();
        this.targetSum = targetSum;
        pathSumRecursive(root, new ArrayList<Integer>(), 0);
        return res;
    }

    public void pathSumRecursive(TreeNode root, ArrayList<Integer> currentPath, int currentSum) {
        // base conditions
        if (root == null) {
            return;
        }

        // action
        currentSum += root.val;
        currentPath.add(root.val);
        // leaf node
        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                res.add(new ArrayList<Integer>(currentPath));
            }
        }
        // recursive
        pathSumRecursive(root.left, currentPath, currentSum);
        pathSumRecursive(root.right, currentPath, currentSum);
        // backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}