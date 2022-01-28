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
    int targ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        targ = targetSum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path){
        // base
        if(root == null) return;
        
        // logic
        currSum += root.val;
        // action
        path.add(root.val);
        // recurse
        helper(root.left, currSum, path);
        if(root.left == null && root.right == null){
            if(currSum == targ){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.right, currSum, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}