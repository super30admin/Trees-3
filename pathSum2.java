// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Approach 1 - data structure inside a data structure is a pointer so in the recursive stack, the 
 * data structure will be a pointer (passed by reference) - all copies will be updated at once. Hence, one 
 * approach is to create a new List while calling the helper function recrusively but this is not an
 * optimal solution for space complexity.
 * 
 * Approach 2 - Use backtracking principle which states action(in this case adding the root.val to 
 * path AL), recruse and backtrack the action taken(i.e remove the recently added root node value when
 * the root comes out of the stack and goes one level up).
 */

import java.util.ArrayList;
import java.util.List;

public class pathSum2 {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path, int target)
    {
        //base
        if(root == null)
            return;
        
        //logic
        currSum += root.val;
        
        //action
        path.add(root.val);
        
        //recurse
        helper(root.left,currSum,new ArrayList<>(path),target);
        
        helper(root.right,currSum,new ArrayList<>(path),target);
        if(root.left == null && root.right == null)
        {
            if(currSum == target)
            {
                result.add(new ArrayList<>(path));
            }
        }
        
        path.remove(path.size() - 1);
    }
}
