// Time Complexity : O(n^2)
// Space Complexity : O(h) where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class PathSum2BackTracking {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, new ArrayList<>(), 0, targetSum);
        return result;
    }

    private void helper(TreeNode root, List<Integer> path, int currSum, int targetSum) {
        if (root == null) return;

        currSum += root.val;
        // action
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        // recurse
        helper(root.left, path, currSum, targetSum);
        helper(root.right, path, currSum, targetSum);
        // backtrack
        path.remove(path.size() - 1);
    }
}
