// Time Complexity : O(n) 
// Space Complexity : O(1) 
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
class PathSum2 {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        //null check
        if(root == null) return result;
        
        helper( root, 0, new ArrayList<>(), targetSum ); //passing start value to helper
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path, int target) {
        if(root == null) return; //checking if root is null
        
        //logic
        
        //action
        path.add(root.val); //adding root to path List
        currSum = currSum + root.val; //adding root's val to sum
        if(root.left == null && root.right == null) { //if left & right is null
            if(currSum == target) { //checking it sum has reached target
                result.add(new ArrayList<>(path)); //putting path in arrayList and that inside the result List
            }
        }
        //recursion
        helper(root.left, currSum, path, target); //on left
        helper(root.right, currSum, path, target); //on right
        
        path.remove(path.size() - 1); //backtracking
        
    }
}