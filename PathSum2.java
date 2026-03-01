// Time Complexity : O(n)
// Space Complexity : O(H) , height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Create a helper function which would keep track of currentsum by adding root's value in each recursion
and also keeping track of the visited values through a list and recurse the same process for both left and
right children. We will only add the visited path list to our result on the case of leaf nodes and when
target sum is met. We also need to traverse through right branch after we hit leaf node of a specific root,
so, we need to backtrack by 1 position so we can compute that.
 */
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
        helper(root, targetSum, 0 , new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if(root == null)
            return;

        //action
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        //recurse
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        //backtrack
        path.remove(path.size() - 1);

    }
}