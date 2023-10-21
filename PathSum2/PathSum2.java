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

 /* Time Complexity : O(n)
 * 	n - size of the tree */
/* Space Complexity : O(h) 
 * 	h - height of the tree */
 // Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());//currNode, target, currSum, path
        return result;
    }

    private void helper(TreeNode root, int target, int currSum, List<Integer> path){
        //base case
        if(root == null) return;

        //logic
        currSum += root.val;
        path.add(root.val);

        //check if leaf
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }

        //recursion
        helper(root.left, target, currSum, path);
        helper(root.right, target, currSum, path);
        
        //backtrack
        path.remove(path.size() - 1);
    }
}