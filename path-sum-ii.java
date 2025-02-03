// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    // TC = O(N), ignoring the cases where path is copied to result as those will be very less, SC = O(H)
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root, int targetSum, int currentSum, List<Integer> path) {
        // base
        if(root == null) return;
        // logic
        currentSum += root.val;
        path.add(root.val);
        // action
// see that we are adding copy of the ArrayList everytime we find path as DS in a DS is always a pointer,& it goes by reference, so when we are removing (backtrack), it is always going to return an empty ArrayList
        if(root.left == null && root.right == null && currentSum == targetSum) res.add(new ArrayList<>(path));
        // recurse
        helper(root.left, targetSum, currentSum, path);
        helper(root.right, targetSum, currentSum, path);
        // backtrack - undo what action was taken
        path.remove(path.size() - 1);
    }
}