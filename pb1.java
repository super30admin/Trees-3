class Solution {
    private List<List<Integer>> result; // Declare result as a class-level variable

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    private void dfs(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }

        // Add current node value to the current path and update the current sum
        currSum += root.val;
        path.add(root.val);

        // Check if it's a leaf node and the current sum matches the target sum
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(path)); // Add a copy of the current path to the result
            }
        } else {
            // Recursively call dfs on left and right subtrees
            dfs(root.left, currSum, path, targetSum);
            dfs(root.right, currSum, path, targetSum);
        }

        // Backtrack: remove the last added element before returning
        path.remove(path.size() - 1);
    }
}
