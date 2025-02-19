// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class PathSum2 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, new ArrayList<>(), 0, targetSum);
        return result;
    }

    private void helper(TreeNode root, List<Integer> path, int currSum, int targetSum) {
        if (root == null) return;

        currSum += root.val;
        List<Integer> li = new ArrayList<>(path);
        li.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(li);
            }
            return;
        }

        helper(root.left, li, currSum, targetSum);
        helper(root.right, li, currSum, targetSum);
    }
}
