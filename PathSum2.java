// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// took currsum to store the sum till the leaf
// once leaf was reached compared with target sum and add the path to the result
// removed the last value in the path if the target sum was not reached

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        if (root == null)
            return result;
        helper(root, targetSum, 0, new ArrayList());
        return result;

    }

    public void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if (root == null)
            return;
        currSum = currSum + root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList(path));
            }
        }
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);
        path.remove(path.size() - 1);
    }
}