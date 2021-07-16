// Time Complexity : O(n)
// Space Complexity : O(n)
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

 //Back Tracking Alogorithm used to improve the efficiency
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
        //we are using only one list to store values
        helper(root.left, targetSum, curSum, path);
        
        //check if left and right are null and cursum == tragetSum
        if(root.left == null && root.right == null && curSum == targetSum){
            //creating new array list, because in the last line we are remove the value everytime, so it becomes empty list 
            //creating new list, we copy the path elements before its removed
            result.add(new ArrayList<>(path));
        }
            
        //right
        helper(root.right, targetSum, curSum, path);
        
        //remove last element
        path.remove(path.size()-1);
    
    }
}
