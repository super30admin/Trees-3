// Time Complexity : O(n)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


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
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList<>();

        helper(root, targetSum, 0, null);
        return result;
    }

    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path) {
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

        helper(root.left, targetSum, sum, path);
        helper(root.right, targetSum, sum, path);
    }
}