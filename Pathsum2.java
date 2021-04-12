// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here  with comments explaining your approach

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path) {
        if (root == null)
            return;

        sum = sum + root.val;
        // add the current root value to the list
        path.add(root.val);
        // when path with target found add it in result
        if (root.left == null && root.right == null && sum == targetSum) {
            result.add(new ArrayList<>(path));
        }
        helper(root.left, targetSum, sum, path);
        helper(root.right, targetSum, sum, path);
        // To backtrack to the previous node when we reach the end
        path.remove(path.size() - 1);
    }
}