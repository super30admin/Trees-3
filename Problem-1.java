// Time Complexity : O(n)
// Space Complexity : O(h) for stack & O(h) for new list = O(h) 
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: I used the same logic Jaspinder explained. 

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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        helper(root, new ArrayList<>(), targetSum, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> path, int targetSum, int curSum){
        //base case
        if(root == null) return;
        curSum = curSum + root.val;
        // List<Integer> newPath = new ArrayList<>(path);
        //action
        path.add(root.val);
        //check leaf
        if(root.left == null && root.right == null){
            if(curSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, path, targetSum, curSum);
        helper(root.right, path, targetSum, curSum);

        //backtrack
        path.remove(path.size() - 1);
    }
}