// Time Complexity : O(N)
// Space Complexity :O(H) + O(H),arryList and stack holds nodes eqaul to height of the tree
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
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int sum, int targetSum, List<Integer> path) {
        //base
        if(root == null) return;
        
        //logic
        path.add(root.val);
        sum+=root.val;
        if(root.left == null &&  root.right == null) {
            if(sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left, sum, targetSum, path);
        helper(root.right, sum, targetSum, path);
        path.remove(path.size()-1);
    }
}