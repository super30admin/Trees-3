// Time Complexity : O(n^2) - since we are creating copy of the path to be added into result
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * backtracking 
 * https://leetcode.com/problems/path-sum-ii/
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	Note: A leaf is a node with no children.
	
	Example:
	
	Given the below binary tree and sum = 22,
 */
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        result = new ArrayList<>();
        
        helper(root, sum, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int target, int currSum, List<Integer> path) {
        
        if(root == null) return;
        
        currSum+=root.val;
        path.add(root.val);
        
        //action
        if(root.left == null && root.right == null && currSum == target){
            //since we are changing the path while unwinding recursion, we need to
            //add new copy of current path to result than just adding path
            result.add(new ArrayList<>(path));
        }
        
        //recurse
        helper(root.left, target, currSum, path);
        helper(root.right, target, currSum, path);
        
        //backtrack
        path.remove(path.size() -1);
    }
}