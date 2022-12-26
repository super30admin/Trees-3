// Path Sum II

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


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
    private List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        inorder(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    private void inorder(TreeNode root, int currSum, List<Integer> path, int targetSum){
        
        if(root == null)
            return;

        currSum += root.val;
        List<Integer> newList = new ArrayList<>(path);
        newList.add(root.val);

        inorder(root.left, currSum, newList, targetSum);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(newList);
            }
        }

        inorder(root.right, currSum, newList, targetSum);
    }
}