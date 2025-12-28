// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no

/*
we are using DFS and backtracking to solve this one
we add value of the current node and if it a leaf node check if that is equal to
target sum we add it path to result

*/

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;

    }

    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path) {
        // logic
        if (root == null)
            return;

        // action
        currSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        // recurce
        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);

        // backtrack
        path.remove(path.size() - 1);
    }
}