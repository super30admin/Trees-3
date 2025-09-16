// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Using recursion, calcluate the sum of nodes at every path and check if its equal to the targetSUm
//if its equal then add the path to the result list and recursively call for left and right nodes
//after recursive calls, remove the last path added
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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
        
    }

    private void helper(TreeNode root, int currSum, int target, List<Integer> path) {
        //base
        if(root == null) return;
        //logic
        currSum +=root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(currSum == target) {
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currSum, target, path);
        helper(root.right, currSum, target, path);
        path.remove(path.size() - 1);
    }
}
