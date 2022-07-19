import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;
        if (root == null)
            return result;

        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currSum) {
        // base
        if (root == null)
            return;

        // logic
        path.add(root.val);
        currSum = currSum + root.val;

        if (root.left == null && root.right == null) {
            if (currSum == target) {
                result.add(new ArrayList<>(path));
            }
        }
        // recurse
        helper(root.left, currSum);
        helper(root.right, currSum);

        // backtrack
        path.remove(path.size() - 1);
    }

}