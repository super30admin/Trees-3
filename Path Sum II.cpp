// TC = O(N)
// SC = O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    // TC = O(N) , ignoring the cases where the path is copied to result as those will be very less
    // SC = O(H)
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // null
        if(root == null) return result;
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path, int target) {
        // base
        if(root == null) return;
        // logic
        currSum += root.val;
        // action
        path.add(root.val);
        // recurse
        helper(root.left, currSum, path, target);
        helper(root.right, currSum, path, target);
        if((root.left == null && root.right == null) && currSum == target) 
            // creating a deep copy and adding as the path would be empty at the end of backtrack
            result.add(new ArrayList<>(path)); 
        // backtrack
        path.remove(path.size() - 1);
    }
}