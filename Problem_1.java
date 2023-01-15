// 113. Path Sum II
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approch
// here we will apply backtracking. For the action we'll traverse all the path, add value of the root to the path & check it's equal to target sum or not.
// If it's equal then create a new list each time to add the paths. Hence every lists have different references & won't get mutated.
// then apply recursion on left & right child. When we are done with a node, we'll backtrack. Make sure to remove that node so that will not have all the nodes in that path.

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
    private List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        //base
        if(root == null)
            return;

        //logic
        currSum += root.val;
        //action
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        //recurse
        helper(root.left, currSum, path, targetSum);
        helper(root.right, currSum, path, targetSum);
        //backtrack
        path.remove(path.size() - 1);
    }
}