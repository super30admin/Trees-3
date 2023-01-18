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

// Time Complexity = O(N^2)
// Space Complexity = O(N*H)

class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>(); 
        helper(root, new ArrayList<>(), 0, targetSum);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> path, int currSum, int targetSum){
        // base condition
        List<Integer> li = new ArrayList<>(path);
        if(root == null) return;
        
        
        currSum += root.val;
        li.add(root.val);
        // logic 
        if(root.left == null && root.right == null && currSum == targetSum){
            result.add(li);
        }
        
        //left
        helper(root.left, li, currSum, targetSum);
        
        //right
        helper(root.right, li, currSum, targetSum);
        
    }
}

// With Backtracking
// Time Complexity = O(N)
// Space Complexity = O(H)

class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>(); 
        helper(root, new ArrayList<>(), 0, targetSum);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> path, int currSum, int targetSum){
        // base condition
        if(root == null) return;
        
        currSum += root.val;
        path.add(root.val);
        // logic 
        if(root.left == null && root.right == null && currSum == targetSum){
            result.add(new ArrayList<>(path));
        }
        
        //left
        helper(root.left, path, currSum, targetSum);
        
        //right
        helper(root.right, path, currSum, targetSum);
        
        //backtrack
        path.remove(path.size() - 1);
    }
}