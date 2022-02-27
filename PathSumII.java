
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class PathSumII {

    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        helper(root, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path) {
        if (root == null)
            return;

        // logic
        currSum += root.val;
        path.add(root.val);
        helper(root.left, currSum, path);
        if (root.left == null && root.right == null) {
            if (currSum == target) {
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.right, currSum, path);
        // backtrack
        path.remove(path.size() - 1);

    }
}

// TC: O(n) SC: O(n)