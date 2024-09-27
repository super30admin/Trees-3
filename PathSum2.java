// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        // helper(root, targetSum, 0, null, result);
        helperBacktracking(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }
        
    // Time Complexity : O(n^2)
    // Space Complexity : O(n^2)
    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        sum += root.val;
        if (path == null) {
            path = new ArrayList<>();
        } else {
            path = new ArrayList<>(path);
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(path);
            }
        }

        helper(root.left, targetSum, sum, path, result);
        helper(root.right, targetSum, sum, path, result);
    }

    private void helperBacktracking(TreeNode root, int targetSum, int sum, List<Integer> path,
            List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        System.out.println("path: " + path + "   root: " + Optional.ofNullable(root.val).orElseGet(() -> null));

        path.add(root.val);
        sum += root.val;
        int size = path.size();
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        helperBacktracking(root.left, targetSum, sum, path, result);
        helperBacktracking(root.right, targetSum, sum, path, result);
        path.remove(path.size() - 1);
    }
}