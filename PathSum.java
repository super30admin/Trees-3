// Time Complexity : O(N^2) - no. of nodes in the tree
// Space Complexity : O(N) - h is height of the tree
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
class PathSum {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if(root == null)  return;

        currSum += root.val;

        List<Integer> li = new ArrayList<>(path);
        li.add(root.val);

        if(root.left == null && root.right == null && targetSum == currSum) {
            result.add(li);
        }

        helper(root.left, targetSum, currSum, li);
        helper(root.right, targetSum, currSum, li);
    }
}