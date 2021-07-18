// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<List<Integer>>();
        
        if(root == null)
            return result;
        
        helper(root, targetSum, 0, new ArrayList<Integer>());
        
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
        //base
        if(root == null) return;
        
        //logic:
        //we add the current value of the root to the sum
        currSum += root.val;
        path.add(root.val);
        
        helper(root.left, targetSum, currSum, new ArrayList<>(path));
        
        //check if it is the leaf and it matches the sum we need
        if(root.left == null && root.right == null && targetSum == currSum){
            result.add(path);
        }
        
        helper(root.right, targetSum, currSum, new ArrayList<>(path));
        
    }
}






