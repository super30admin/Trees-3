// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.List;

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
class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        List<Integer> path = new ArrayList<>();

        helper(root, targetSum, path, res, 0);

        return res;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res, int sum){
        if(root == null){
            return;
        }

        sum += root.val;

        path.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == targetSum){
                res.add(new ArrayList<>(path));
            }
        }

        helper(root.left, targetSum, path, res, sum);

        helper(root.right, targetSum, path, res, sum);

        path.remove(path.size()-1);
    }
}