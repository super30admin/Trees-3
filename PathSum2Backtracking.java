// Time Complexity : O(n + h) => We are visiting n nodes and whenever sum is equal to target we copy the h elements
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. In if condition where we check targetSum was using return which gave incorrect output

/*
Approach: In this approach we have global variable sum and local variable current sum which holds the sum of that particular recursive call. Used backtraking with action, recurse & backtrack steps. Action was to add the root value to path and backtracking was to remove once done with the left & right recurse call
 */
class Solution {
    int sum;
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return new ArrayList<>();
        }

        sum = 0;
        result = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, int currentSum, List<Integer> path) {

        if (root == null) {
            return;
        }

        currentSum = currentSum + root.val;

        //action
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        //recurse
        dfs(root.left, targetSum, currentSum, path);
        dfs(root.right, targetSum, currentSum, path);

        //backtracking
        path.remove(path.size()-1);

    }
}