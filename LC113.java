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

//Time Complexity : O(n) for backtracking, O(n^2) for recursive
//Space Complexity : O(n)

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum);
        
        return result;
    }
    
    private void helper(TreeNode root, int currsum, List<Integer> path, int target)
    {
        //base
        if(root == null)
        {
            return ;
        }
        
        //logic
        
        //action
        currsum = currsum + root.val;
        path.add(root.val);
        
        
        //recurse
        helper(root.left, currsum, path ,target);       //Create new ArrayList for recursive solution
        
        if(root.left == null && root.right == null) 
        {
            if(currsum == target)
            {
                result.add(new ArrayList<>(path));      // If we don't have new ArrayList here we will be left with...
                                                        // two empty lists as backtracking will remove all the nodes 
            }
        }
        
        helper(root.right, currsum,path,target);      //Create new ArrayList for recursive solution
        
        //backtrack
        path.remove(path.size()-1);
        
        return;
    }
}