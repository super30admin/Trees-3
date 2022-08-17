// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Backtracking approach with normal recursion of tree

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<List<Integer>>();
        
        helper(root, targetSum, 0, new ArrayList<Integer>());
        
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> currPath) {
        // Base Case
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            // leaf node
            if (currSum + root.val == targetSum) {
                
                List<Integer> temp_res = new ArrayList<>(currPath);
                temp_res.add(root.val);
                
                // System.out.println(temp_res);
                result.add(temp_res);
            }
        }
        
        //Logic
        
        // Action
        currPath.add(root.val);
        
        // Recurse
        helper(root.left, targetSum, currSum + root.val, currPath);
        helper(root.right, targetSum, currSum + root.val, currPath);
        
        // Backtrack
        currPath.remove(currPath.size() - 1);
    }
}