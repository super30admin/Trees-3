import java.util.*;
// Time Complexity : O(n) where n is the number of nodes
// Space Complexity :O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        helper(root, targetSum, new ArrayList());
        return result;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> path) {
        // base
        if (root == null)
            return;

        // logic
        targetSum -= root.val;
        // action
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                result.add(new ArrayList(path));
            }
        }
        // recurse
        helper(root.left, targetSum, path);
        helper(root.right, targetSum, path);
        path.remove(path.size() - 1);
    }
}