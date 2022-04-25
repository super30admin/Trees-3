// Time Complexity : O(n) n is the number of elements
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially faced problem understanding the concept of pass by value and pass by reference.


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
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root ==null) return result;
        helper(root, 0, targetSum);
        return result;
    }
    private void helper(TreeNode root, int currSum, int targetSum){
        if(root==null) return;
        currSum = currSum + root.val;
         //action
        path.add(root.val);
        
        if(root.left==null&&root.right==null){
            if(currSum==targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        
        //recurse
        helper(root.left,currSum,targetSum);
        helper(root.right,currSum,targetSum);
        //backtrack
        path.remove(path.size()-1);
    }
}