// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(root, targetSum, 0);
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum) {
        // base
        if (root == null)
            return;
        // logic
        currSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(path)); // Create a new deep copy since the previous path become empty.
            }
        }

        // recurse
        helper(root.left, targetSum, currSum);
        helper(root.right, targetSum, currSum);

        // backtrack
        path.remove(path.size() - 1);

    }
}