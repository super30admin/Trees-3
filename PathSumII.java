import java.util.ArrayList;
import java.util.List;

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

// Appraoch 2: Optimize space
// Time: O(n); n = number of nodes
// Space: h + h ~= O(h) for path and recursive stack
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path) {

        // base
        if (root == null) {
            return;
        }

        // action
        path.add(root.val);
        sum += root.val;

        // logic
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        // recurse
        helper(root.left, targetSum, sum, path);
        helper(root.right, targetSum, sum, path);
        
        // backtrack - remove last index
        path.remove(path.size() - 1);
    }
}