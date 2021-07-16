// Time Complexity : O(n^2) [arrayList + recursive stack]
// Space Complexity :O(n^2) [arrayList + recursive stack]
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        helper(root, targetSum, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int curSum, List<Integer> path){
        //base
        if(root == null)
            return;
        
        //logic
        curSum += root.val;
        path.add(root.val);
        //left
        helper(root.left, targetSum, curSum, new ArrayList<>(path));
        
        //check if left and right are null and cursum == tragetSum
        if(root.left == null && root.right == null && curSum == targetSum){
            result.add(path);
        }
            
        //right
        helper(root.right, targetSum, curSum, new ArrayList<>(path));
    
    }
}

