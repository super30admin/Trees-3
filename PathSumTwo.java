// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :Yes
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        currSum = currSum + root.val;
        if (currSum == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}