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
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(h), where h is the height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        pathSumHelper(root, targetSum, 0, new ArrayList<>());
        return result;
    }


    public void pathSumHelper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if(root == null) return;

        currSum += root.val;
        path.add(root.val);
        pathSumHelper(root.left, targetSum, currSum, path);
        pathSumHelper(root.right, targetSum, currSum, path);

        if(root.left == null && root.right == null && currSum == targetSum)
            result.add(new ArrayList<>(path));

        path.remove(path.size()-1);

    }
}