// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root, sum, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int sum, int currSum, List<Integer> path){
        if(root == null)
            return;
        int newSum = currSum + root.val;
        //add the root value in the list
        path.add(root.val);
        //check if leaf node present
        if(root.left == null && root.right == null){
            //check if new sum is equal to the incoming sum
            if(newSum == sum){
                result.add(path);
            }
        }
        helper(root.left, sum, newSum, new ArrayList<>(path));
        helper(root.right, sum, newSum, new ArrayList<>(path));
    }
}