// Time Complexity : O(n)
// Space Complexity : O(h)
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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // TC: O(n)
        // SC: O(h)
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path, int target) {
        if(root == null) {
            return;
        }
        
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(currSum == target) {
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left, currSum, path, target);
        helper(root.right, currSum, path, target);
        path.remove(path.size() - 1);
    }
}

