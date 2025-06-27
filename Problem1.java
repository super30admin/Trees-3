// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
class Problem1 {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        if (root == null)
            return result;
        dfs(root, 0, new ArrayList<>());
        return result;
    }
    private void dfs(TreeNode root, int currSum, List<Integer> temp) {
        // Base 
        if (root == null)
            return;
        currSum += root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == currSum) {
                result.add(new ArrayList<>(temp));
            }
        }
        // logic
        dfs(root.left, currSum, temp);
        dfs(root.right, currSum, temp);
        // backtrack
        temp.remove(temp.size() - 1);
    }
}
