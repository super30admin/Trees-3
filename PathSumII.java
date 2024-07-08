// Time Complexity : O(n)
// Space Complexity : O(nh)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
class Solution {
  List<List<Integer>> result;
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    result = new ArrayList<>();
    helper(root, targetSum, 0, new ArrayList<>());
    return result;
  }

  void helper(TreeNode root, int targetSum, int currentSum, List<Integer> level) {
    // Base
    if(root == null) return;
    // Logic
    // Add tthe present value of root to the list and currentSum.
    level.add(root.val);
    currentSum += root.val;
    // Check if root is a leaf node.
    if(root.left == null && root.right == null) {
      if(targetSum == currentSum) {
        result.add(new ArrayList<>(level));
      }
    }
    // Recurse
    helper(root.left, targetSum, currentSum, level);
    helper(root.right, targetSum, currentSum, level);
    // Backtrack and remove the node after completing both left and right calls.
    level.remove(level.size()-1);
  }
}