// Time Complexity : O(nh)
// Space Complexity : O(nh)
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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, targetSum, 0, path);
        return result;
    }

    public void helper(TreeNode root, int targetSum, int curSum, ArrayList<Integer> path) {
        // base
        if (root == null)
            return;

        // logic
        curSum = curSum + root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (curSum == targetSum) {
                result.add(path);
            }
            return;
        }

        // recursion
        helper(root.left, targetSum, curSum, new ArrayList<>(path));
        helper(root.right, targetSum, curSum, new ArrayList<>(path));

        // backtracking
        path.remove(path.size() - 1);
        curSum = curSum - root.val;
    }
}