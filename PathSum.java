// Time Complexity : O(N ^ 2)
// Space Complexity : O(N ^ 2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        result = new ArrayList<>();
        
        if(root == null) return result;
        
        helper(root, sum, 0, new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(TreeNode root, int sum, int curSum, List<Integer> path) {
        
        if(root == null) return;
        
        int newSum = curSum + root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null) {
            if(newSum == sum) {
                result.add(path);
            }
        }
        
        helper(root.left, sum, newSum, new ArrayList<>(path));
        helper(root.right, sum, newSum, new ArrayList<>(path));
    }
}