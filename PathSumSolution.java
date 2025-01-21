/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class PathSumSolution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    private void dfs(TreeNode root, int currSum, ArrayList<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }
        currSum = currSum + root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, currSum, path, targetSum);
        dfs(root.right, currSum, path, targetSum);
        path.remove(path.size() - 1);
    }
}