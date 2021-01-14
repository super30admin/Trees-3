// Time Complexity : O(n) if we do not consider the new Array creation when curSum = target
// Space Complexity : O(n) for the path list that we maintain
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
    int target;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();

        if(root == null) return result;
        target = sum;
        helper(root, 0, new ArrayList<Integer>());
        return result;
    }

//Recursion with Backtracking
    public void helper(TreeNode root, int curSum, List<Integer> path) {
        //base case
        if(root == null) return;

        curSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(curSum == target){
                List<Integer> validPath = new ArrayList<>(path);
                result.add(validPath);
            }
        }

        helper(root.left, curSum, path);
        helper(root.right, curSum, path);

        //back tracking
        path.remove(path.size()-1);


    }
}
