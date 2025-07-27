// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach :Maintain a path list. Iterate to leaf from root and keep adding nodes to path along the traversal. If at leaf sum = target
/// return that list else backtrack

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        helper(root, path, 0, targetSum, result);
        return result;
    }
    public void helper(TreeNode root, List<Integer> path, int currSum, int targetSum, List<List<Integer>> result){
        if(root == null){
            return;
        }
        currSum += root.val;
        path.add(root.val);
        
        helper(root.left, path, currSum, targetSum, result);
        
        helper(root.right, path, currSum, targetSum, result);
        if(root.left==null && root.right==null){
            if(currSum == targetSum){
                result.add(new ArrayList<Integer>(path));
            }
        }
        path.remove(path.size()-1);
    }
}